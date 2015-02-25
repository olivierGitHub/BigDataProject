package bigdata.userInterface.connexion;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ProgressTracker extends Application {

    final int N_SECS = 10;

    @Override
    public void start(Stage stage) throws Exception {
        Task task = createTask();

        stage.setScene(
                new Scene(
                        createLayout(
                                task
                        )
                )
        );
        stage.show();

        new Thread(task).start();
    }

    private Task<Void> createTask() {
        return new Task<Void>() {
            @Override public Void call() {
                for (int i=0; i < N_SECS; i++) {
                    if (isCancelled()) {
                        break;
                    }
                    // uncomment updateProgress call if you want to show progress
                    // rather than let progress remain indeterminate.
                    // updateProgress(i, N_SECS);
                    updateMessage((N_SECS - i) + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return null;
                    }
                }

                updateMessage(0 + "");
                updateProgress(N_SECS, N_SECS);

                return null;
            }
        };
    }

    private HBox createLayout(Task task) {
        HBox layout = new HBox(10);

        layout.getChildren().setAll(
                createProgressIndicator(task),
                createCounter(task)
        );

        layout.setAlignment(Pos.CENTER_RIGHT);
        layout.setPadding(new Insets(10));

        return layout;
    }

    private ProgressIndicator createProgressIndicator(Task task) {
        ProgressIndicator progress = new ProgressIndicator();

        progress.progressProperty().bind(task.progressProperty());

        return progress;
    }

    private Label createCounter(Task task) {
        Label counter = new Label();

        counter.setMinWidth(20);
        counter.setAlignment(Pos.CENTER_RIGHT);
        counter.textProperty().bind(task.messageProperty());
        counter.setStyle("-fx-border-color: forestgreen;");

        return counter;
    }

    public static void main(String[] args) {
        launch(args);
    }
}