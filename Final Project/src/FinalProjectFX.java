/*
Author : Taki Kishala
Date : 8/29/2025

This programme is an tool for helping people find pets based on their preferences
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.*;

/**
 * A simple class that represents a Pet.
 * Each pet has a name, description, activity level,
 * info about kids, and an image path.
 */
class Pet {
    private final String name;
    private final String description;
    private final int activityLevel;
    private final boolean goodWithKids;
    private final String imagePath;

    /**
     * Creates a new Pet object.
     * @param name the pet's name
     * @param description short info about the pet
     * @param activityLevel activity level from 1–5
     * @param goodWithKids if the pet is good with kids
     * @param imagePath location of the pet image
     */
    public Pet(String name, String description, int activityLevel, boolean goodWithKids, String imagePath) {
        this.name = name;
        this.description = description;
        this.activityLevel = activityLevel;
        this.goodWithKids = goodWithKids;
        this.imagePath = imagePath;
    }

    /** @return the pet's name */
    public String getName() {
        return name;
    }

    /** @return the pet description */
    public String getDescription() {
        return description;
    }

    /** @return the activity level (1–5) */
    public int getActivityLevel() {
        return activityLevel;
    }

    /** @return true if pet is good with kids */
    public boolean isGoodWithKids() {
        return goodWithKids;
    }

    /** @return the path to the image */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Combines pet details into one string.
     * @return info about the pet
     */
    public String getInfo() {
        return name + " :\n" + description +
                "\nActivity Level: " + activityLevel +
                "\nGood with kids: " + (goodWithKids ? "Yes" : "No");
    }
}

/**
 * Main JavaFX app for the Pet Choose Helper.
 * Lets user pick a pet by preference or get a recommendation.
 */
public class FinalProjectFX extends Application {
    private final List<Pet> pets = new ArrayList<>();

    /**
     * Starts the JavaFX app.
     * @param primaryStage the main window
     */
    @Override
    public void start(Stage primaryStage) {
        seedPets();

        // main menu
        Label title = new Label("Pet Choose Helper");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        title.getStyleClass().add("title-label");

        Button prefBtn = styledButton("Choose by Preference");
        Button recBtn = styledButton("Get Recommendation");
        Button exitBtn = styledButton("Exit");

        VBox menuLayout = new VBox(20, title, prefBtn, recBtn, exitBtn);
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setPadding(new Insets(30));
        menuLayout.getStyleClass().add("menu-layout");

        Scene menuScene = new Scene(menuLayout, 650, 900);
        menuScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // preference scene
        Label prefLabel = new Label("Select a Pet:");
        prefLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        prefLabel.getStyleClass().add("section-label");

        ComboBox<String> petDropdown = new ComboBox<>();
        for (Pet pet : pets){
            petDropdown.getItems().add(pet.getName());
        }
        petDropdown.setPrefWidth(200);

        TextArea petInfo = new TextArea();
        petInfo.setEditable(false);
        petInfo.setWrapText(true);
        petInfo.setPrefHeight(120);
        petInfo.getStyleClass().add("text-area");

        ImageView petImage = new ImageView();
        petImage.setFitWidth(200);
        petImage.setPreserveRatio(true);

        Button backBtn1 = styledButton("Back");

        VBox prefLayout = new VBox(15, prefLabel, petDropdown, petInfo, petImage, backBtn1);
        prefLayout.setAlignment(Pos.CENTER);
        prefLayout.setPadding(new Insets(20));
        prefLayout.getStyleClass().add("pref-layout");

        Scene prefScene = new Scene(prefLayout, 650, 900);
        prefScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // recommendation scene
        Label recTitle = new Label("Find Your Best Pet Match");
        recTitle.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        recTitle.getStyleClass().add("title-label");

        GridPane form = new GridPane();
        form.setVgap(10);
        form.setHgap(10);
        form.setPadding(new Insets(15));
        form.getStyleClass().add("grid-pane");

        ComboBox<Integer> activityBox = new ComboBox<>();
        activityBox.getItems().addAll(1,2,3,4,5);
        form.add(new Label("Activity Level (1–5):"), 0, 0);
        form.add(activityBox, 1, 0);

        ComboBox<String> kidsBox = new ComboBox<>();
        kidsBox.getItems().addAll("Yes", "No");
        form.add(new Label("Do you have kids?"), 0, 1);
        form.add(kidsBox, 1, 1);

        ComboBox<String> homeBox = new ComboBox<>();
        homeBox.getItems().addAll("Small Apartment", "Medium Home", "Large House");
        form.add(new Label("Home Size:"), 0, 2);
        form.add(homeBox, 1, 2);

        ComboBox<String> timeBox = new ComboBox<>();
        timeBox.getItems().addAll("<30 mins", "≈1 hour", "Several hours");
        form.add(new Label("Daily Care Time:"), 0, 3);
        form.add(timeBox, 1, 3);

        ComboBox<String> allergyBox = new ComboBox<>();
        allergyBox.getItems().addAll("Yes", "No");
        form.add(new Label("Allergies?"), 0, 4);
        form.add(allergyBox, 1, 4);

        ComboBox<String> quietBox = new ComboBox<>();
        quietBox.getItems().addAll("Yes", "No");
        form.add(new Label("Prefer Quiet Pet?"), 0, 5);
        form.add(quietBox, 1, 5);

        Button recommendBtn = styledButton("🔍 Find My Pet");
        TextArea recResult = new TextArea();
        recResult.setEditable(false);
        recResult.setWrapText(true);
        recResult.setPrefHeight(120);
        recResult.getStyleClass().add("text-area");

        ImageView recImage = new ImageView();
        recImage.setFitWidth(200);
        recImage.setPreserveRatio(true);

        Button backBtn2 = styledButton("Back");

        VBox recLayout = new VBox(15, recTitle, form, recommendBtn, recResult, recImage, backBtn2);
        recLayout.setAlignment(Pos.CENTER);
        recLayout.setPadding(new Insets(20));
        recLayout.getStyleClass().add("rec-layout");

        Scene recScene = new Scene(recLayout, 650, 900);
        recScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        // button actions
        prefBtn.setOnAction(e -> primaryStage.setScene(prefScene));
        recBtn.setOnAction(e -> primaryStage.setScene(recScene));
        exitBtn.setOnAction(e -> primaryStage.close());
        backBtn1.setOnAction(e -> primaryStage.setScene(menuScene));
        backBtn2.setOnAction(e -> primaryStage.setScene(menuScene));

        petDropdown.setOnAction(e -> {
            String choice = petDropdown.getValue();
            if (choice != null) {
                pets.stream()
                        .filter(p -> p.getName().equals(choice))
                        .findFirst()
                        .ifPresent(p -> {
                            petInfo.setText(p.getInfo());
                            petImage.setImage(new Image(getClass().getResource(p.getImagePath()).toExternalForm()));
                        });
            }
        });

        recommendBtn.setOnAction(e -> {
            if (activityBox.getValue() == null || kidsBox.getValue() == null ||
                    homeBox.getValue() == null || timeBox.getValue() == null ||
                    allergyBox.getValue() == null || quietBox.getValue() == null) {
                recResult.setText("Please answer all questions!");
                return;
            }

            int activity = activityBox.getValue();
            boolean kids = kidsBox.getValue().equals("Yes");
            int homeSize = homeBox.getSelectionModel().getSelectedIndex() + 1;
            int timeAvailable = timeBox.getSelectionModel().getSelectedIndex() + 1;
            boolean allergies = allergyBox.getValue().equals("Yes");
            boolean quietPreference = quietBox.getValue().equals("Yes");

            Pet best = getBestPet(activity, kids, homeSize, timeAvailable, allergies, quietPreference);
            recResult.setText(" Best Match \n\n" + best.getInfo());
            recImage.setImage(new Image(getClass().getResource(best.getImagePath()).toExternalForm()));
        });

        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Pet Choose Helper");
        primaryStage.show();
    }

    /**
     * Loads the pets into the list with default values.
     */
    private void seedPets() {
        pets.add(new Pet("Dog", "Loyal and playful, needs daily exercise.", 5, true, "/images/dog.jpg"));
        pets.add(new Pet("Cat", "Independent and affectionate, low maintenance.", 2, true, "/images/cat.jpg"));
        pets.add(new Pet("Bird", "Colorful and social, likes interaction.", 3, false, "/images/bird.jpg"));
        pets.add(new Pet("Fish", "Peaceful and easy to care for.", 1, false, "/images/fish.jpg"));
        pets.add(new Pet("Rabbit", "Gentle and cuddly, moderate care needs.", 2, true, "/images/rabbit.jpg"));
    }

    /**
     * Finds the best pet based on user answers.
     * @param activity activity level chosen
     * @param kids if the user has kids
     * @param homeSize size of home
     * @param timeAvailable how much time user has
     * @param allergies if user has allergies
     * @param quietPreference if user wants a quiet pet
     * @return the best matching Pet
     */
    private Pet getBestPet(int activity, boolean kids, int homeSize, int timeAvailable, boolean allergies, boolean quietPreference) {
        Pet best = null;
        int bestScore = Integer.MIN_VALUE;

        for (Pet pet : pets) {
            int score = 0;

            // activity match
            score -= Math.abs(pet.getActivityLevel() - activity) * 2;

            // kids check
            if (kids && pet.isGoodWithKids()) score += 3;

            // home size logic
            if (pet.getName().equals("Dog") && homeSize == 1) score -= 3;
            if (pet.getName().equals("Fish") && homeSize == 1) score += 2;

            // time available
            if (timeAvailable == 1 && pet.getName().equals("Dog")) score -= 3;
            if (timeAvailable == 1 && pet.getName().equals("Fish")) score += 2;

            // allergies
            if (allergies && (pet.getName().equals("Dog") || pet.getName().equals("Cat") ||
                    pet.getName().equals("Bird") || pet.getName().equals("Rabbit")))
                score -= 4;

            // quiet preference
            if (quietPreference && pet.getName().equals("Bird")) score -= 2;
            if (quietPreference && pet.getName().equals("Fish")) score += 2;

            if (score > bestScore) {
                best = pet;
                bestScore = score;
            }
        }
        return best;
    }

    /**
     * Creates a button with my style settings.
     * @param text the button label
     * @return a styled Button
     */
    private Button styledButton(String text) {
        Button btn = new Button(text);
        btn.getStyleClass().add("button");
        btn.setPrefWidth(200);
        return btn;
    }
}
