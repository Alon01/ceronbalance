package com.github.hector.ceronbalance;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Punto de entrada de escritorio. Arranca el contexto de Spring y abre la ventana de JavaFX.
 *
 * <p>Se ejecuta con {@code ./mvnw javafx:run}.</p>
 */
public class JavaFxApplication extends Application {

	private ConfigurableApplicationContext context;

	@Override
	public void init() {
		context = new SpringApplicationBuilder(CeronbalanceApplication.class)
				.headless(false)
				.run(getParameters().getRaw().toArray(String[]::new));
	}

	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane(new Label("CeronBalance"));
		stage.setTitle("CeronBalance");
		stage.setScene(new Scene(root, 800, 600));
		stage.show();
	}

	@Override
	public void stop() {
		if (context != null) {
			context.close();
		}
		Platform.exit();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
