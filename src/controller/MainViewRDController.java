package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.SalesDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Sales;
import sql_crud.Sales_FindAll;


public class MainViewRDController implements Initializable {
	
	@FXML private TableView<Sales> fx_table = new TableView<>();
	@FXML private TableColumn<Sales,Long>   fx_column_id;
	@FXML private TableColumn<Sales,String> fx_column_name;
	@FXML private TableColumn<Sales,Long> fx_column_total_profit;
	@FXML private TableColumn<Sales,Long> fx_column_total_expense;
	@FXML private TableColumn<Sales,Long> fx_column_total_sale;
	
	@FXML private TableColumn<Sales,String> fx_column_settle;
	@FXML private TableColumn<Sales,String> fx_column_charge_person;
	@FXML private TableColumn<Sales,String> fx_column_customers_name;
	@FXML private TableColumn<Sales,String> fx_column_genres_name;
	@FXML private TableColumn<Sales,String> fx_column_invoice_status;
	@FXML private TableColumn<Sales,String> fx_column_memo;
	@FXML private TableColumn<Sales,String> fx_column_income_date;
	@FXML private TableColumn<Sales,String> fx_column_billing_date;
	@FXML private TableColumn<Sales,String> fx_column_distribute_director;
	@FXML private TableColumn<Sales,String> fx_column_distribute_sale;
	@FXML private TableColumn<Sales,String> fx_column_distribute_design;
	@FXML private TableColumn<Sales,String> fx_column_distribute_coding;
	@FXML private TableColumn<Sales,String> fx_column_distribute_system;
	@FXML private TableColumn<Sales,Long> fx_column_director_price;
	@FXML private TableColumn<Sales,Long> fx_column_sale_price;
	@FXML private TableColumn<Sales,Long> fx_column_design_price;
	@FXML private TableColumn<Sales,Long> fx_column_coding_price;
	@FXML private TableColumn<Sales,Long> fx_column_system_price;
	
	@FXML private TableColumn<Sales,String> fx_column_created_at;
	@FXML private TableColumn<Sales,String> fx_column_update_at;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		Sales_FindAll sql = new Sales_FindAll();
		new SalesDao(sql);
		for(Sales record:sql.recordList){
			fx_table.getItems().add(record);
		}
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<Sales,Long>("id"));
		fx_column_name.setCellValueFactory(new PropertyValueFactory<Sales,String>("name"));
		fx_column_total_profit.setCellValueFactory(new PropertyValueFactory<Sales,Long>("total_profit"));
		fx_column_total_expense.setCellValueFactory(new PropertyValueFactory<Sales,Long>("total_expense"));
		fx_column_total_sale.setCellValueFactory(new PropertyValueFactory<Sales,Long>("total_sale"));
		fx_column_settle.setCellValueFactory(new PropertyValueFactory<Sales,String>("settle"));
		fx_column_charge_person.setCellValueFactory(new PropertyValueFactory<Sales,String>("charge_person"));
		fx_column_customers_name.setCellValueFactory(new PropertyValueFactory<Sales,String>("customers_name"));
		fx_column_genres_name.setCellValueFactory(new PropertyValueFactory<Sales,String>("genres_name"));
		fx_column_invoice_status.setCellValueFactory(new PropertyValueFactory<Sales,String>("invoice_status"));
		fx_column_memo.setCellValueFactory(new PropertyValueFactory<Sales,String>("memo"));
		fx_column_income_date.setCellValueFactory(new PropertyValueFactory<Sales,String>("income_date"));
		fx_column_billing_date.setCellValueFactory(new PropertyValueFactory<Sales,String>("billing_date"));
		fx_column_distribute_director.setCellValueFactory(new PropertyValueFactory<Sales,String>("staff_director_name"));
		fx_column_distribute_sale.setCellValueFactory(new PropertyValueFactory<Sales,String>("staff_sale_name"));
		fx_column_distribute_design.setCellValueFactory(new PropertyValueFactory<Sales,String>("staff_design_name"));
		fx_column_distribute_coding.setCellValueFactory(new PropertyValueFactory<Sales,String>("staff_coding_name"));
		fx_column_distribute_system.setCellValueFactory(new PropertyValueFactory<Sales,String>("staff_system_name"));
		fx_column_director_price.setCellValueFactory(new PropertyValueFactory<Sales,Long>("distribute_director_price"));
		fx_column_sale_price.setCellValueFactory(new PropertyValueFactory<Sales,Long>("distribute_sale_price"));
		fx_column_design_price.setCellValueFactory(new PropertyValueFactory<Sales,Long>("distribute_design_price"));
		fx_column_coding_price.setCellValueFactory(new PropertyValueFactory<Sales,Long>("distribute_coding_price"));
		fx_column_system_price.setCellValueFactory(new PropertyValueFactory<Sales,Long>("distribute_system_price"));
		
		fx_column_created_at.setCellValueFactory(new PropertyValueFactory<Sales,String>("created_at"));
		fx_column_update_at.setCellValueFactory(new PropertyValueFactory<Sales,String>("update_at"));
//		addButtonToTable(edit(),"","編集");
//		addButtonToTable(delete(),"","削除");
	}
//	private Consumer<Sales> delete(){
//		Consumer<Sales> consumer = customers -> {
//			Sales_DeleteById sql = new Sales_DeleteById(customers.idProperty().get());
//			new SalesDao(sql);
//	    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
//	    	    fx_table.getItems().clear();
//	    	}
//			Sales_FindAll sql2 = new Sales_FindAll();
//			new SalesDao(sql2);
//			for(Sales record:sql2.recordList){
//				fx_table.getItems().add(record);
//			}
//		};
//		return consumer;
//	}
//	private Consumer<Sales> edit(){
//		Consumer<Sales> consumer = customers -> {
//			System.out.println("editbuttonclick");
//			SalesTableEController.customers = customers;
//			Stage stage = new StageGenerator().createStage("customers_table-E.fxml",new BorderPane());
//			stage.setTitle("既存顧客編集 ID:"+ customers.idProperty().get());
//		};
//		return consumer;
//	}
	
	private void addButtonToTable(Consumer<Sales> consumer,String columnTitle,String btnCaption) {
		TableColumn<Sales, Void> colBtn = new TableColumn<>(columnTitle);

		Callback<TableColumn<Sales, Void>, TableCell<Sales, Void>> cellFactory = new Callback<TableColumn<Sales, Void>, TableCell<Sales, Void>>() {
			@Override
			public TableCell<Sales, Void> call(final TableColumn<Sales, Void> param) {
				final TableCell<Sales, Void> cell = new TableCell<Sales, Void>() {

					private final Button btn = new Button(btnCaption);

					{
						btn.setOnAction((ActionEvent event) -> {
							Sales customers = getTableView().getItems().get(getIndex());
							consumer.accept(customers);
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
