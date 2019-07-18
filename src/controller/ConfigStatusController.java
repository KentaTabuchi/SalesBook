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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Statuses;
import sql_crud.Statuses_DeleteById;
import sql_crud.Statuses_FindAllById;
import sql_crud.Statuses_Insert;
import sql_crud.Statuses_UpdateById;


public class ConfigStatusController implements Initializable {
	
	@FXML private TableView<Statuses> fx_table = new TableView<>();
	@FXML private TableColumn<Statuses,Long> fx_column_id;
	@FXML private TableColumn<Statuses,String> fx_column_name;
	@FXML private TextField fx_text_name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		Statuses_FindAllById sql = new Statuses_FindAllById();
		new SalesDao(sql);
		for(Statuses record:sql.recordList){
			fx_table.getItems().add(record);
		}
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<Statuses,Long>("id"));
		fx_column_name.setCellValueFactory(new PropertyValueFactory<Statuses,String>("name"));
		addButtonToTable(edit("編集テスト"),"","編集");
		addButtonToTable(delete(),"","削除");
	}
	
	private Consumer<Statuses> delete(){
		Consumer<Statuses> consumer = statuses -> {
			Statuses_DeleteById sql = new Statuses_DeleteById(statuses.idProperty().get());
			new SalesDao(sql);
			
	    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
	    	    fx_table.getItems().clear();
	    	}
	    	
			Statuses_FindAllById sql2 = new Statuses_FindAllById();
			new SalesDao(sql2);
			for(Statuses record:sql2.recordList){
				fx_table.getItems().add(record);
			}
		};
		return consumer;
	}
	
	private Consumer<Statuses> edit(String newText){
		Consumer<Statuses> consumer = statuses -> {
			Statuses_UpdateById sql = new Statuses_UpdateById(statuses.idProperty().get(),newText);
			new SalesDao(sql);
			
	    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
	    	    fx_table.getItems().clear();
	    	}
	    	
			Statuses_FindAllById sql2 = new Statuses_FindAllById();
			new SalesDao(sql2);
			for(Statuses record:sql2.recordList){
				fx_table.getItems().add(record);
			}
		};
		return consumer;
	}
	
	@FXML
	public void OnAddButtonClick(){
		Statuses_Insert sql = new Statuses_Insert(fx_text_name.getText());
		new SalesDao(sql);
		
    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
    	    fx_table.getItems().clear();
    	}
    	
		Statuses_FindAllById sql2 = new Statuses_FindAllById();
		new SalesDao(sql2);
		for(Statuses record:sql2.recordList){
			fx_table.getItems().add(record);
		}
	}
	
/**
 * 
 * @param consumer    : ActionEvent on Button Clicked. Written by lamda. 
 * @param columnTitle : Table Column head caption.
 * @param btnCaption  : Caption of generated button.
 */
	private void addButtonToTable(Consumer<Statuses> consumer,String columnTitle,String btnCaption) {
		TableColumn<Statuses, Void> colBtn = new TableColumn<>(columnTitle);

		Callback<TableColumn<Statuses, Void>, TableCell<Statuses, Void>> cellFactory = new Callback<TableColumn<Statuses, Void>, TableCell<Statuses, Void>>() {
			@Override
			public TableCell<Statuses, Void> call(final TableColumn<Statuses, Void> param) {
				final TableCell<Statuses, Void> cell = new TableCell<Statuses, Void>() {

					private final Button btn = new Button(btnCaption);

					{
						btn.setOnAction((ActionEvent event) -> {
							Statuses statuses = getTableView().getItems().get(getIndex());
							consumer.accept(statuses);
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
