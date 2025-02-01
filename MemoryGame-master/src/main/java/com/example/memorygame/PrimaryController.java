package com.example.memorygame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private Label acertosLabel;

    @FXML
    private Label tentativasLabel;

    @FXML
    private FlowPane imagesFlowPane;

    private ArrayList<Combinacao> cartasNoJogo;

    private Combinacao primeiraCarta, segundaCarta;
    private int numDeTentativas;
    private int numDeAcertos;

    @FXML
    void playAgain() {
        primeiraCarta=null;
        segundaCarta=null;

        DeckDeCartas deck = new DeckDeCartas();
        deck.shuffle();
        cartasNoJogo = new ArrayList<>();

        for (int i =0; i<imagesFlowPane.getChildren().size()/2; i++)
        {
            Carta cartaDealt = deck.dealTopCarta();
            cartasNoJogo.add(new Combinacao(cartaDealt.getSuit(),cartaDealt.getnomeAnimal()));
            cartasNoJogo.add(new Combinacao(cartaDealt.getSuit(),cartaDealt.getnomeAnimal()));
        }
        Collections.shuffle(cartasNoJogo);
        virarTodasCartas();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeImageView();
        playAgain();
    }

    /*Vai add um numero para cada ImageView e colocar a parte de trás nas cartas*/
    private void initializeImageView()
    {
        for (int i=0; i<imagesFlowPane.getChildren().size();i++)
        {
            //"cast" the Node to be of type ImageView
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            imageView.setImage(new Image(Carta.class.getResourceAsStream("images/interrogacao.png")));
            imageView.setUserData(i);

            //register a click listener
            imageView.setOnMouseClicked(event -> {
                flipcarta((int) imageView.getUserData());
            });
        }
    }

    /*Mostra a parte de trás das que nn combinaram*/
    private void virarTodasCartas()
    {
        for (int i=0; i<cartasNoJogo.size();i++)
        {
            ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(i);
            Combinacao carta = cartasNoJogo.get(i);

            if (carta.combinou())
                imageView.setImage(carta.getImage());
            else
                imageView.setImage(carta.getVersoCarta());
        }
    }

    private void flipcarta(int indexOfcarta)
    {
        if (primeiraCarta==null && segundaCarta==null)
            virarTodasCartas();

        ImageView imageView = (ImageView) imagesFlowPane.getChildren().get(indexOfcarta);

        if (primeiraCarta==null)
        {
            primeiraCarta = cartasNoJogo.get(indexOfcarta);
            imageView.setImage(primeiraCarta.getImage());
        }
        else if (segundaCarta==null)
        {
            numDeTentativas++;
            segundaCarta = cartasNoJogo.get(indexOfcarta);
            imageView.setImage(segundaCarta.getImage());
            checkDeCombinacao();
            updateLabels();
        }
    }

    private void updateLabels()
    {
        acertosLabel.setText(Integer.toString(numDeAcertos));
        tentativasLabel.setText(Integer.toString(numDeTentativas));
    }

    private void checkDeCombinacao()
    {
        if (primeiraCarta.mesmaCarta(segundaCarta))
        {
            numDeAcertos++;
            primeiraCarta.setCombinou(true);
            segundaCarta.setCombinou(true);
        }
        primeiraCarta=null;
        segundaCarta=null;
    }

}
