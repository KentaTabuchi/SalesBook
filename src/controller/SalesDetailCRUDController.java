package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.SalesDao;
import command.StageGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Customers;
import model.SalesDetails;
import sql_crud.Customers_FindAll;
import sql_crud.SalesDetails_DeleteById;
import sql_crud.SalesDetails_FindAll;
import sql_crud.SalesDetails_Insert;


public class SalesDetailCRUDController implements Initializable {
	
	@FXML private TableView<SalesDetails> fx_table = new TableView<>();
	@FXML private TableColumn<SalesDetails,Long>   fx_column_id;
	@FXML private TableColumn<SalesDetails,String> fx_column_detail;
	@FXML private TableColumn<SalesDetails,String> fx_column_price;
	@FXML private TextField fx_text_detail;
	@FXML private TextField fx_text_price;
	//@FXML private TextField fx_text_discount;
	@FXML private TableColumn<SalesDetails,String> fx_column_vendor_id;
	@FXML private ComboBox<String> fx_combo_customers_id;
	@FXML private TableColumn<SalesDetails,String> fx_column_vendor_name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		SalesDetails_FindAll sql = new SalesDetails_FindAll();
		new SalesDao(sql);
		for(SalesDetails record:sql.recordList){
			fx_table.getItems().add(record);
		}
		Customers_FindAll sql2 = new Customers_FindAll();
		new SalesDao(sql2);
		for(Customers item:sql2.recordList){
			fx_combo_customers_id.getItems().add(item.idProperty().get()+":"+item.nameProperty().get());
		}
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<SalesDetails,Long>("id"));
		fx_column_detail.setCellValueFactory(new PropertyValueFactory<SalesDetails,String>("description"));
		fx_column_price.setCellValueFactory(new PropertyValueFactory<SalesDetails,String>("price"));
		fx_column_vendor_id.setCellValueFactory(new PropertyValueFactory<SalesDetails,String>("vendor_id"));
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
		SalesDetails_Insert sql = new SalesDetails_Insert(
				10L, //ここに画面遷移前から引っ張ってきた売上IDを移す。
				Long.valueOf(fx_combo_customers_id.getValue().substring(0,fx_combo_customers_id.getValue().indexOf(":"))),    //ここにコンボボックスのテキストを整形して仕入れ先IDを取り出す。
				fx_text_detail.getText(),
				Float.valueOf(fx_text_price.getText())
				);
		new SalesDao(sql);
    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
    	    fx_table.getItems().clear();
    	}
		SalesDetails_FindAll sql2 = new SalesDetails_FindAll();
		new SalesDao(sql2);
		for(SalesDetails record:sql2.recordList){
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
			SalesDetails_FindAll sql2 = new SalesDetails_FindAll();
			new SalesDao(sql2);
			for(SalesDetails record:sql2.recordList){
				fx_table.getItems().add(record);
			}
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