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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.SalesDetail;


public class SalesDetailCRUDController implements Initializable {
	
	@FXML private TableView<SalesDetail> fx_table = new TableView<>();
	@FXML private TableColumn<SalesDetail,Long>   fx_column_id;
	@FXML private TableColumn<SalesDetail,String> fx_column_detail;
	@FXML private TableColumn<SalesDetail,String> fx_column_established_price;
	@FXML private TableColumn<SalesDetail,String> fx_column_discount;
	@FXML private TableColumn<SalesDetail,String> fx_column_price;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
//		SalesDetail_FindAll sql = new SalesDetail_FindAll();
//		new SalesDao(sql);
//		for(SalesDetail record:sql.recordList){
//			fx_table.getItems().add(record);
//		}
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<SalesDetail,Long>("id"));
		fx_column_detail.setCellValueFactory(new PropertyValueFactory<SalesDetail,String>("detail"));
		fx_column_established_price.setCellValueFactory(new PropertyValueFactory<SalesDetail,String>("established_price"));
		fx_column_discount.setCellValueFactory(new PropertyValueFactory<SalesDetail,String>("discount"));
		fx_column_price.setCellValueFactory(new PropertyValueFactory<SalesDetail,String>("price"));
		//addButtonToTable(edit(),"","編集");
		//addButtonToTable(delete(),"","削除");
	}
//	private Consumer<SalesDetail> delete(){
//		Consumer<SalesDetail> consumer = customers -> {
//			SalesDetail_DeleteById sql = new SalesDetail_DeleteById(customers.idProperty().get());
//			new SalesDao(sql);
//	    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
//	    	    fx_table.getItems().clear();
//	    	}
//			SalesDetail_FindAll sql2 = new SalesDetail_FindAll();
//			new SalesDao(sql2);
//			for(SalesDetail record:sql2.recordList){
//				fx_table.getItems().add(record);
//			}
//		};
//		return consumer;
//	}
//	private Consumer<SalesDetail> edit(){
//		Consumer<SalesDetail> consumer = customers -> {
//			System.out.println("editbuttonclick");
//			SalesDetailTableEController.customers = customers;
//			Stage stage = new StageGenerator().createStage("customers_table-E.fxml",new BorderPane());
//			stage.setTitle("既存顧客編集 ID:"+ customers.idProperty().get());
//		};
//		return consumer;
//	}
	
	private void addButtonToTable(Consumer<SalesDetail> consumer,String columnTitle,String btnCaption) {
		TableColumn<SalesDetail, Void> colBtn = new TableColumn<>(columnTitle);

		Callback<TableColumn<SalesDetail, Void>, TableCell<SalesDetail, Void>> cellFactory = new Callback<TableColumn<SalesDetail, Void>, TableCell<SalesDetail, Void>>() {
			@Override
			public TableCell<SalesDetail, Void> call(final TableColumn<SalesDetail, Void> param) {
				final TableCell<SalesDetail, Void> cell = new TableCell<SalesDetail, Void>() {

					private final Button btn = new Button(btnCaption);

					{
						btn.setOnAction((ActionEvent event) -> {
							SalesDetail item = getTableView().getItems().get(getIndex());
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
