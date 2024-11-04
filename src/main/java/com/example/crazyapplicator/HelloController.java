package com.example.crazyapplicator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloController {
    float color_price;
    float size_price;
    float personalisation_price;
    float total_customisation;
    @FXML
    private Text bike_price;
    @FXML
    private Text customisation_price;
    @FXML
    private Text total_bike_price;
    @FXML
    private ImageView imgVVile;
    @FXML
    private ImageView imgVCourse;
    @FXML
    private ImageView chosen_bike;
    @FXML
    private ChoiceBox<Colors> classic_colors;
    @FXML
    private ChoiceBox<Size> sizes;
    @FXML
    private ChoiceBox<Personalisation> personalisation;

    ArrayList<Option> city_bike_personalisation = new ArrayList<>();
    ArrayList<Option> course_bike_personalisation = new ArrayList<>();
    Velo velo_course = new Velo("Course", "C:\\Users\\Soran\\IdeaProjects\\CrazyApplicator\\src\\main\\resources\\com\\example\\crazyapplicator\\img\\velo_course_gris.jpg", 550, city_bike_personalisation);
    Velo velo_ville = new Velo("Ville", "C:\\Users\\Soran\\IdeaProjects\\CrazyApplicator\\src\\main\\resources\\com\\example\\crazyapplicator\\img\\velo_ville_vert.jpg", 349, course_bike_personalisation);

    /* Course bike options. */
    Colors gris_perle = new Colors("Gris Perle", "#CECECE", 0);
    Colors bleu_abysse = new Colors("Bleu Abysse", "#003366", 10);
    Colors orange_papaye = new Colors("Orange Papaye", "#FF4500", 1000);

    /* City bike options. */
    Colors vert_cedre = new Colors("Vert Cèdre", "#00561B", 14);
    Colors bleu_nuage = new Colors("Bleu Nuage", "#73C2FB", 15);
    Colors bleu_acier = new Colors("Bleu Acier", "#3A8EBA", 17896);

    /* All bike options. */
    Size size_s = new Size("S", -10);
    Size size_m = new Size("M", 0);
    Size size_l = new Size("L", 10);
    Size size_xl = new Size("XL", 100);
    Size size_xxl = new Size("XXL", 1000);
    Personalisation personalisation_ = new Personalisation("Jsp", 999);

    private void update_total_price() {
        total_customisation = color_price + size_price + personalisation_price;
        customisation_price.setText(Double.toString(total_customisation));
        total_bike_price.setText(String.valueOf(Float.parseFloat(bike_price.getText()) + Float.parseFloat(customisation_price.getText())));
    }

    @FXML
    protected void on_bike_img_clicked(MouseEvent evt) {
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Pane view = fxmlloader.load();

            chosen_bike = (ImageView) view.lookup("#chosen_bike");
            bike_price = (Text) view.lookup("#bike_price");
            customisation_price = (Text) view.lookup("#customisation_price");
            total_bike_price = (Text) view.lookup("#total_bike_price");
            classic_colors = (ChoiceBox<Colors>) view.lookup("#classic_colors");
            sizes = (ChoiceBox<Size>) view.lookup("#sizes");
            personalisation = (ChoiceBox<Personalisation>) view.lookup("#personalisation");

            // Clear items to avoid duplicates.
            classic_colors.getItems().clear();
            sizes.getItems().clear();

            if (evt.getSource() == imgVVile) {
                chosen_bike.setImage(new Image(velo_ville.getImg_link()));
                bike_price.setText(String.valueOf(velo_ville.getPrice()));

                classic_colors.getItems().addAll(vert_cedre, bleu_nuage, bleu_acier);
                classic_colors.setValue(vert_cedre);
            } else if (evt.getSource() == imgVCourse) {
                chosen_bike.setImage(new Image(velo_course.getImg_link()));
                bike_price.setText(String.valueOf(velo_course.getPrice()));

                classic_colors.getItems().addAll(gris_perle, bleu_abysse, orange_papaye);
                classic_colors.setValue(gris_perle);
            }

            sizes.getItems().addAll(size_s, size_m, size_l, size_xl, size_xxl);
            sizes.setValue(size_m);
            personalisation.getItems().add(personalisation_);

            classic_colors.getSelectionModel().selectedItemProperty()
                    .addListener((obs, oldVal, newVal) -> {
                if (newVal != null) {color_price = newVal.getPrice();}
                update_total_price();
            });

            sizes.getSelectionModel().selectedItemProperty()
                    .addListener((obs, oldVal, newVal) -> {
                if (newVal != null) {size_price = newVal.getPrice();}
                update_total_price();
            });

            personalisation.getSelectionModel().selectedItemProperty()
                    .addListener((obs, oldVal, newVal) -> {
                if (newVal != null) {personalisation_price = newVal.getPrice();}
                update_total_price();
            });

            Stage new_stage = (Stage) ((ImageView) evt.getSource()).getScene().getWindow();
            new_stage.setScene(new Scene(view));
            new_stage.show();
        } catch (Exception err) {
            System.err.println(err.getMessage());
            err.printStackTrace();
        }
    }
}
