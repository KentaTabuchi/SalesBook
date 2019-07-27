package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.SalesDao;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Customers;
import model.SalesDetails;
import sql_calc.SalesDetail_Sum_Price;
import sql_calc.Sales_Max_Id;
import sql_crud.Customers_FindAll;
import sql_crud.SalesDetails_DeleteById;
import sql_crud.SalesDetails_FindAll;
import sql_crud.SalesDetails_Insert;


public class SalesDetailCRUDController implements Initializable {
	
	@FXML protected TableView<SalesDetails> fx_table = new TableView<>();
	@FXML private TableColumn<SalesDetails,Long>   fx_column_id;
	@FXML private TableColumn<SalesDetails,String> fx_column_detail;
	@FXML private TableColumn<SalesDetails,Long> fx_column_price;
	@FXML private TableColumn<SalesDetails,Long> fx_column_vendor_id; //仕入先id
	@FXML private TableColumn<SalesDetails,String> fx_column_vendor_name; //仕入先
	
	@FXML private TextField fx_text_detail;
	@FXML private TextField fx_text_price;
	
	@FXML private ComboBox<String> fx_combo_customers_id;
	
	@FXML private Label fx_label_vendor_id;
	@FXML private Label fx_label_customer_name;
	@FXML private Label fx_label_sales_id;
	@FXML private Label fx_label_sum;
	
	@FXML private Button fx_button_close;
	private Long vendor_id;
	private String vendor_name;
	protected StringProperty total_pay;
	private Long sales_id;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		setComboBox();
		this.vendor_id = SalesTableCController.vendor_id;
		this.vendor_name = SalesTableCController.vendor_name;

		Sales_Max_Id sql = new Sales_Max_Id();
		new SalesDao(sql);
		sales_id = sql.result+1;


		setLabels();
		refreshSumLabel();
		SalesTableCController.total_expense.textProperty().bind(total_pay);
		findAll();
	}
	private void setComboBox(){
		Customers_FindAll sql2 = new Customers_FindAll();
		new SalesDao(sql2);
		for(Customers item:sql2.recordList){
			fx_combo_customers_id.getItems().add(item.idProperty().get()+":"+item.nameProperty().get());
		}
	}
	public void setLabels(){
		fx_label_vendor_id.setText(vendor_id.toString());
		fx_label_customer_name.setText(vendor_name);
		fx_label_sales_id.setText(sales_id.toString());
	}
	public void refreshSumLabel(){
		SalesDetail_Sum_Price sql3= new SalesDetail_Sum_Price();
		sql3.setSales_id(sales_id);
		new SalesDao(sql3);
		fx_label_sum.textProperty().set(sql3.result.toString());
		if(total_pay == null){
			total_pay = new SimpleStringProperty(sql3.result.toString());
		}
		else{
			total_pay.setValue(sql3.result.toString());
		}
		
		
	}
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<SalesDetails,Long>("id"));
		fx_column_detail.setCellValueFactory(new PropertyValueFactory<SalesDetails,String>("description"));
		fx_column_price.setCellValueFactory(new PropertyValueFactory<SalesDetails,Long>("price"));
		fx_column_vendor_id.setCellValueFactory(new PropertyValueFactory<SalesDetails,Long>("vendor_id"));
		fx_column_vendor_name.setCellValueFactory(new PropertyValueFactory<SalesDetails,String>("customer_name"));
		//addButtonToTable(edit(),"","編集");
		addButtonToTable(delete(),"","削除");
	}
	@FXML
	private void OnColumnFinalPriceCommit(){
		//テーブルの売上合計をラベルに表示
		System.out.println("invoke");
	}
	
	@FXML
	private void OnAddButtonClick(){
		
		System.out.println("addbuttonclick");
		System.out.println(Long.valueOf(fx_combo_customers_id.getValue().substring(0,fx_combo_customers_id.getValue().indexOf(":"))));
		insert();
		findAll();
		refreshSumLabel();
	}
	@FXML
	private void OnCloseButtonClick(){
		fx_button_close.getScene().getWindow().hide();
	}
	private void insert(){
		SalesDetails_Insert sql = new SalesDetails_Insert(
				sales_id, //ここに画面遷移前から引っ張ってきた売上IDを移す。
				Long.valueOf(fx_combo_customers_id.getValue().substring(0,fx_combo_customers_id.getValue().indexOf(":"))),   
				fx_text_detail.getText(),
				Long.valueOf(fx_text_price.getText())
				);
		new SalesDao(sql);
	}
	protected void findAll(){
    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
    	    fx_table.getItems().clear();
    	}
		SalesDetails_FindAll sql = new SalesDetails_FindAll();
		sql.setSales_id(sales_id);
		new SalesDao(sql);
		for(SalesDetails record:sql.recordList){
			fx_table.getItems().add(record);
		}
	}

	
	private Consumer<SalesDetails> delete(){
		Consumer<SalesDetails> consumer = model -> {
			SalesDetails_DeleteById sql = new SalesDetails_DeleteById(model.idProperty().get());
			new SalesDao(sql);
	    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
	    	    fx_table.getItems().clear();
	    	}
	    	findAll();
			refreshSumLabel();
		};
		return consumer;
	}
//	private Consumer<SalesDetails> edit(){
//		Consumer<SalesDetails> consumer = customers -> {
//			System.out.println("editbuttonclick");
//			SalesDetailTableEController.customers = customers;
//			Stage stage = new StageGenerator().createStage("customers_table-E.fxml",new BorderPane());
//			stage.setTitle("既存顧客編集 ID:"+ customers.idProperty().get());
//		};
//		return consumer;
//	}
	
	private void addButtonToTable(Consumer<SalesDetails> consumer,String columnTitle,String btnCaption) {
		TableColumn<SalesDetails, Void> colBtn = new TableColumn<>(columnTitle);

		Callback<TableColumn<SalesDetails, Void>, TableCell<SalesDetails, Void>> cellFactory = new Callback<TableColumn<SalesDetails, Void>, TableCell<SalesDetails, Void>>() {
			@Override
			public TableCell<SalesDetails, Void> call(final TableColumn<SalesDetails, Void> param) {
				final TableCell<SalesDetails, Void> cell = new TableCell<SalesDetails, Void>() {

					private final Button btn = new Button(btnCaption);

					{
						btn.setOnAction((ActionEvent event) -> {
							SalesDetails item = getTableView().getItems().get(getIndex());
							consumer.accept(item);
						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
					}
				};
				return cell;
			}
		};
		colBtn.setCellFactory(cellFactory);
		fx_table.getColumns().add(colBtn);
	}
}
