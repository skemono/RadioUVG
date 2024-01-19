module com.radiouvg.radiouvg {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.mockito;
    requires junit;
    requires mockito.all;

    opens com.radiouvg.radiouvg to javafx.fxml;
    exports com.radiouvg.radiouvg;
}