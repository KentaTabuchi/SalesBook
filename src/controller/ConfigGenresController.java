package controller;

import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Genres;
import sql_crud.Genres_FindAll;
import sql_crud.Genres_Insert;
import sql_crud.Genres_UpdateById;
import sql_crud.Genres_DeleteById;


public class ConfigGenresController implements Initializable {
	
	@FXML private TableView<Genres> fx_table = new TableView<>();
	@FXML private TableColumn<Genres,Long> fx_column_id;
	@FXML private TableColumn<Genres,String> fx_column_name;
	@FXML private TextField fx_text_name;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setCellValueFactoryes();
		Genres_FindAll sql = new Genres_FindAll();
		new SalesDao(sql);
		for(Genres record:sql.recordList){
			fx_table.getItems().add(record);
		}
	}
	
	private void setCellValueFactoryes(){
		fx_column_id.setCellValueFactory(new PropertyValueFactory<Genres,Long>("id"));
		fx_column_name.setCellValueFactory(new PropertyValueFactory<Genres,String>("name"));
		addButtonToTable(edit(),"","編集");
		addButtonToTable(delete(),"","削除");
	}
	
	private Consumer<Genres> delete(){
		Consumer<Genres> consumer = genres -> {
			Genres_DeleteById sql = new Genres_DeleteById(genres.idProperty().get());
			new SalesDao(sql);
			
	    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
	    	    fx_table.getItems().clear();
	    	}
	    	
			Genres_FindAll sql2 = new Genres_FindAll();
			new SalesDao(sql2);
			for(Genres record:sql2.recordList){
				fx_table.getItems().add(record);
			}
		};
		return consumer;
	}
	
	private Consumer<Genres> edit(){

		
		Consumer<Genres> consumer = statuses -> {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("編集内容入力");
			dialog.setHeaderText(null);
			dialog.setContentText("変更後の名前を入力してください。");
			Optional<String> result = dialog.showAndWait();
			result.ifPresent(value ->{
				Genres_UpdateById sql = new Genres_UpdateById(statuses.idProperty().get(),value);
				new SalesDao(sql);	
			});
			
	    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
	    	    fx_table.getItems().clear();
	    	}
	    	
			Genres_FindAll sql2 = new Genres_FindAll();
			new SalesDao(sql2);
			for(Genres record:sql2.recordList){
				fx_table.getItems().add(record);
			}
		};
		return consumer;
	}
	
	@FXML
	public void OnAddButtonClick(){
		Genres_Insert sql = new Genres_Insert(fx_text_name.getText());
		new SalesDao(sql);
		
    	for ( int i = 0; i<fx_table.getItems().size(); i++) {
    	    fx_table.getItems().clear();
    	}
    	
		Genres_FindAll sql2 = new Genres_FindAll();
		new SalesDao(sql2);
		for(Genres record:sql2.recordList){
			fx_table.getItems().add(record);
		}
	}
	
/**
 * 
 * @param consumer    : ActionEvent on Button Clicked. Written by lamda. 
 * @param columnTitle : Table Column head caption.
 * @param btnCaption  : Caption of generated button.
 */
	private void addButtonToTable(Consumer<Genres> consumer,String columnTitle,String btnCaption) {
		TableColumn<Genres, Void> colBtn = new TableColumn<>(columnTitle);

		Callback<TableColumn<Genres, Void>, TableCell<Genres, Void>> cellFactory = new Callback<TableColumn<Genres, Void>, TableCell<Genres, Void>>() {
			@Override
			public TableCell<Genres, Void> call(final TableColumn<Genres, Void> param) {
				final TableCell<Genres, Void> cell = new TableCell<Genres, Void>() {

					private final Button btn = new Button(btnCaption);

					{
						btn.setOnAction((ActionEvent event) -> {
							Genres genres = getTableView().getItems().get(getIndex());
							consumer.accept(genres);
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
