package com.radiouvg.radiouvg;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RadioAppTest {

    @Mock
    private Stage stage;

    @Mock
    private FXMLLoader fxmlLoader;

    @Test
    public void testStart() throws IOException {
        RadioApp app = new RadioApp();
        app.start(stage);

        verify(fxmlLoader).load();
        verify(stage).setScene(new Scene(fxmlLoader.load(), 640, 400));
        verify(stage).setTitle("Radio UVG");
        verify(stage).show();
    }

    @Test
    public void testGetRadio() {
        RadioApp app = new RadioApp();
        Radio radio = app.getRadio();

        // Assert that the returned radio is not null (will be more specific once we have the Radio class code)
        assertNotNull(radio);
    }

    // Test for main() method is not necessary as it only calls launch()
}
