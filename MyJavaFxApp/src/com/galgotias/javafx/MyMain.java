package com.galgotias.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application
{
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void init() throws Exception
	{
		System.out.println("init");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		System.out.println("start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0, menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("TEMPERATURE CONVERTER TOOL");
		primaryStage.show();
	}
	private MenuBar createMenu()
	{
		//file menu
		Menu fileMenu=new Menu("File");
		MenuItem newMenuItem= new MenuItem("New");
		newMenuItem.setOnAction(event ->{
			System.out.println("new mwnu item clicked");
		});

		SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
		MenuItem quitMenuItem= new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem, quitMenuItem
		);

		//help menu
		Menu helpMenu=new Menu("Help");
		MenuItem aboutApp= new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);
		//menu bar
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	private void aboutApp()
	{
		Alert alertDialog= new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("my 1st desktop app");
		alertDialog.setHeaderText("learning javafx");
		alertDialog.setContentText("just now i am a begneer but soon i will be pro");

		ButtonType yesBtn=new ButtonType("Yes");
		ButtonType noBtn=new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

		Optional<ButtonType> clickedBtn=alertDialog.showAndWait();

		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn){
			System.out.println("Yes btn");
		}
		else{
			System.out.println("no btn");
		}
	}


	@Override
	public void stop() throws Exception
	{
		System.out.println("stop");
		super.stop();
	}
}
