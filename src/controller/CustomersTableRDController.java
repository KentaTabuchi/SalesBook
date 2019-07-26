package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.SalesDao;
import command.StageGenerator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Customers;
import sql_crud.Customers_FindAll;
import sql_crud.Customers_DeleteById;


public class CustomersTableRDController implements Initializable {
	
	@FXML private TableView<Customers> fx_table = new TableView<>();
	@FXML private TableColumn<Customers,Long>   fx_column_id;
	@FXML private TableColumn<Customers,String> fx_column_name;
	@FXML private TableColumn<Customers,String> fx_column_name_kana;
	@FXML private TableColumn<Customers,String> fx_column_tel;
	@FXML private TableColumn<Customers,String> fx_column_address1;
	@FXML private TableColumn<Customers,String> fx_column_address2;
	@FXML private TableColumn<Customers,String> fx_column_address3;
	@FXML private TableColumn<Customers,String> fx_column_zip;
	@FXML private TableColumn<Customers,String> fx_column_email;
	@FXML private TableColumn<Customers,String> fx_column_person_in_charge;
	@FXML private TableColumn<Customers,String> fx_column_created_at;
	@FXML private TableColumn<Customers,String> fx_column_update_at;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		Customers_FindAll sql = new Customers_FindAll();
		new SalesDao(sql);
		for(Customers record:sql.recordList){
			fx_table.getItems().add(record);
		}
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<Customers,Long>("id"));
		fx_column_name.setCellValueFactory(new PropertyValueFactory<Customers,String>("name"));
		fx_column_name_kana.setCellValueFactory(new PropertyValueFactory<Customers,String>("name_kana"));
		fx_column_tel.setCellValueFactory(new PropertyValueFactory<Customers,String>("tel"));
		fx_column_address1.setCellValueFactory(new PropertyValueFactory<Customers,String>("address1"));
		fx_column_address2.setCellValueFactory(new PropertyValueFactory<Customers,String>("address2"));
		fx_column_address3.setCellValueFactory(new PropertyValueFactory<Customers,String>("address3"));
		fx_column_zip.setCellValueFactory(new PropertyValueFactory<Customers,String>("zip"));
		fx_column_email.setCellValueFactory(new PropertyValueFactory<Customers,String>("email"));
		fx_column_person_in_charge.setCellValueFactory(new PropertyValueFactory<Customers,String>("person_in_charge"));
		fx_column_created_at.setCellValueFactory(new PropertyValueFactory<Customers,String>("created_at"));
		fx_column_update_at.setCellValueFactory(new PropertyValueFactory<Customers,String>("update_at"));
		addButtonToTable(edit(),"","編集");
		addButtonToTable(delete(),"","削除");
	}
	private Consumer<Customers> delete(){
		Consumer<Customers> consumer = customers -> {
			Customers_DeleteById sql = new Customers_DeleteById(customers.idProperty().get());
			new SalesDao(sql);
	    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
	    	    fx_table.getItems().clear();
	    	}
			Customers_FindAll sql2 = new Customers_FindAll();
			new SalesDao(sql2);
			for(Customers record:sql2.recordList){
				fx_table.getItems().add(record);
			}
		};
		return consumer;
	}
	private Consumer<Customers> edit(){
		Consumer<Customers> consumer = customers -> {
			System.out.println("editbuttonclick");
			CustomersTableEController.customers = customers;
			Stage stage = new StageGenerator().createStage("customers_table-E.fxml",new BorderPane());
			stage.setTitle("既存顧客編集 ID:"+ customers.idProperty().get());
		};
		return consumer;
	}
	
	private void addButtonToTable(Consumer<Customers> consumer,String columnTitle,String btnCaption) {
		TableColumn<Customers, Void> colBtn = new TableColumn<>(columnTitle);

		Callback<TableColumn<Customers, Void>, TableCell<Customers, Void>> cellFactory = new Callback<TableColumn<Customers, Void>, TableCell<Customers, Void>>() {
			@Override
			public TableCell<Customers, Void> call(final TableColumn<Customers, Void> param) {
				final TableCell<Customers, Void> cell = new TableCell<Customers, Void>() {

					private final Button btn = new Button(btnCaption);

					{
						btn.setOnAction((ActionEvent event) -> {
							Customers customers = getTableView().getItems().get(getIndex());
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
