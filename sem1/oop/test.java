@Override
public void start(Stage stage) {
    // Create a slider with min, max, and initial value
    Slider slider = new Slider(1, 5, 3);

    // Show tick marks and labels
    slider.setShowTickMarks(true);
    slider.setShowTickLabels(true);

    // Set the major tick unit to 1
    slider.setMajorTickUnit(1);

    // Set the minor tick count to 0
    slider.setMinorTickCount(0);

    // Enable snapping to ticks
    slider.setSnapToTicks(true);

    // Create a string converter to format the labels
    slider.setLabelFormatter(new StringConverter<Double>() {
        @Override
        public String toString(Double value) {
            // Return a string of rating options according to the value
            int option = value.intValue();
            switch (option) {
                case 1: return "Very poor";
                case 2: return "Poor";
                case 3: return "Average";
                case 4: return "Good";
                case 5: return "Very good";
                default: return "";
            }
        }

        @Override
        public Double fromString(String string) {
            // Return the number of the rating option in the string
            switch (string) {
                case "Very poor": return 1d;
                case "Poor": return 2d;
                case "Average": return 3d;
                case "Good": return 4d;
                case "Very good": return 5d;
                default: return 0d;
            }
        }
    });

    // Create a layout and add the slider
    VBox root = new VBox(slider);
    root.setPrefSize(300, 200);

    // Create a scene and show the stage
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Rating Slider Example");
    stage.show();
}

public static void main(String[] args) {
    launch(args);
}