package boundary;

import control.ControlGame;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TelaGame implements Telas, EventHandler<ActionEvent> {
    public TelaGame(Executor e) {
        this.setExecutor(e);
    }

    private ControlGame controlGame = new ControlGame ();

    private Image image1 = new Image(getClass().getResourceAsStream("/img1.png"));
    private Image image2 = new Image(getClass().getResourceAsStream("/img2.png"));
    private Image image3 = new Image(getClass().getResourceAsStream("/img3.png"));
    private Image image4 = new Image(getClass().getResourceAsStream("/img4.png"));
    private Image image5 = new Image(getClass().getResourceAsStream("/img5.png"));
    private Image image6 = new Image(getClass().getResourceAsStream("/img6.png"));


    private Canvas canvas1 = new Canvas(150, 150);
    private GraphicsContext ctx1 = canvas1.getGraphicsContext2D();

    private Canvas canvas2 = new Canvas(150, 150);
    private GraphicsContext ctx2 = canvas2.getGraphicsContext2D();

    private BorderPane paneB = new BorderPane();
    private GridPane paneG1 = new GridPane();
    private GridPane paneG2 = new GridPane ();

    private TextField txtEnergia = new TextField();
    private TextField txtHabilidade = new TextField();
    private TextField txtSorte = new TextField();
    private TextArea txtHistoria = new TextArea();
    private TableView<String> tableView = new TableView<>();
    private Executor executor;

    private Button btnDado = new Button ("Jogar Dado");

    @Override
    public Scene gerarTela() {

        paneG1.add(new Label("Energia"), 0, 0);
        paneG1.add(txtEnergia, 1, 0);
        paneG1.add(new Label("Habilidade"), 0, 1);
        paneG1.add(txtHabilidade, 1, 1);
        paneG1.add(new Label("Sorte"), 0, 2);
        paneG1.add(txtSorte, 1, 2);
        txtEnergia.setEditable(false);
        txtHabilidade.setEditable(false);
        txtSorte.setEditable(false);
        txtHistoria.setEditable(false);

        txtEnergia.setText (Integer.toString (controlGame.gerarEnergiaMax ()));
        txtHabilidade.setText (Integer.toString (controlGame.gerarHabilidadeMax ()));
        txtSorte.setText (Integer.toString (controlGame.gerarSorte ()));
        txtHistoria.setText ("Você é um aventureiro, um espadachim de aluguel, e tem estado perambulando pelas áreas\n" +
                "fronteiriças do norte de seu reino. Tendo sempre desprezado a monotonia da vida de aldeia,\n" +
                "você agora vagueia pela região em busca de riqueza e perigo. Apesar das longas caminhadas e\n" +
                "da dureza da vida ao ar livre, você está satisfeito com seu destino incerto. Não há nada no\n" +
                "mundo que possa lhe inspirar medo, uma vez que você é um guerreiro habilidoso, com muita\n" +
                "prática na arte de eliminar homens e animais cruéis com sua espada de confiança. Nem uma só\n" +
                "vez, durante os últimos dez dias em que esteve viajando nas áreas fronteiriças do norte, você\n" +
                "avistou alguma outra pessoa. Isso não o preocupa em nada, uma vez que você fica feliz na\n" +
                "companhia de si mesmo e aprecia os dias lentos e ensolarados, caçando, comendo e dormindo.\n" +
                "É noite e, tendo degustado um jantar de coelho assado no espeto numa fogueira ao ar livre,\n" +
                "você se instala para dormir embaixo de seu cobertor de pele de carneiro. Há uma lua cheia, e a\n" +
                "luz cintila na lâmina de sua espada de lâmina larga, cravada no chão a seu lado. Você fica\n" +
                "olhando para ela, imaginando quando será a próxima vez em que terá que limpar o sangue de\n" +
                "alguma criatura abjeta de sua lâmina afiada. Estas são terras estranhas, habitadas por feras\n" +
                "repulsivas e fantásticas - Goblins, Trolls e até mesmo Dragões.\n" +
                "Enquanto a chama do fogo de seu acampamento vai morrendo aos poucos, você começa a cair\n" +
                "no sono, e imagens de Trolls de rostos esverdeados que gritam cruzam velozmente sua mente.\n" +
                "De repente, nas moitas à sua esquerda, você ouve um estalo alto de um galho que se quebra\n" +
                "sob um pé desajeitado. Você salta de pé e pega sua espada no chão. Fica de pé, imóvel, mas\n" +
                "alerta, pronto para investir contra o seu adversário ainda fora de vista. Em seguida, você ouve\n" +
                "um gemido, seguido pelo ruído seco de um corpo caindo ao chão. Será uma armadilha?\n" +
                "Lentamente, você caminha na direção da moita de onde o barulho está vindo e\n" +
                "cuidadosamente afasta os galhos. Ao olhar para baixo, você vê um velhinho bem pequeno com\n" +
                "uma grande barba cerrada, seu rosto contorcido em dores. Você se agacha para retirar o elmo\n" +
                "de ferro que cobre sua cabeça já meio calva e repara nas duas setas de besta que estão\n" +
                "cravadas no seu tronco gorducho e protegido por uma cota de malha de ferro. Erguendo-o,\n" +
                "você o carrega até perto do fogo e aviva as brasas já quase apagadas. Depois de cobri-lo com o\n" +
                "cobertor de pele de carneiro, você consegue que o velho beba um pouco de água. Ele tosse e\n" +
                "geme. Senta-se então rigidamente, os olhos fixos à sua frente, e começa a gritar.\n" +
                "- “Vou pegá-los! Vou pegá-los! Não se preocupe, Gillibran, Perna Grande está vindo para lhe\n" +
                "trazer o martelo. Ah, sim, sem dúvida que estou. Ah Sim...\"\n" +
                "O anão, cujo nome você presume que seja Perna Grande, está obviamente delirando por causa\n" +
                "dos dardos de ponta envenenada alojados em seu estômago. Você fica observando, enquanto\n" +
                "ele desaba novamente no chão, depois sussurra o nome dele em seu ouvido. Seus olhos o\n" +
                "encaram fixamente, e ele começa de novo a gritar.");

            btnDado.addEventHandler (ActionEvent.ANY,this);

        new AnimationTimer() {

            int resultadoDado = controlGame.jogarD6 ();
            @Override
            public void handle(long now) {

                switch (resultadoDado) {
                    case 1:
                        ctx1.drawImage(image1, 0, 0);
                        ctx2.drawImage(image1, 0, 0);
                        break;
                    case 2:
                        ctx1.drawImage(image2, 0, 0);
                        ctx2.drawImage(image2, 0, 0);
                        break;
                    case 3 :
                        ctx1.drawImage(image3, 0, 0);
                        ctx2.drawImage(image3, 0, 0);
                        break;
                    case 4 :
                        ctx1.drawImage(image4, 0, 0);
                        ctx2.drawImage(image4, 0, 0);
                        break;
                    case 6 :
                        ctx1.drawImage(image5, 0, 0);
                        ctx2.drawImage(image5, 0, 0);
                        break;
                    case 5 :
                        ctx1.drawImage(image6, 0, 0);
                        ctx2.drawImage(image6, 0, 0);
                        break;
                }
            }
        }.start();

        paneG2.add (canvas1,0,0);
        paneG2.add (canvas2,1,0);

        paneB.setCenter(paneG2);
        paneB.setLeft(paneG1);
        paneB.setRight(tableView);
        paneB.setBottom(txtHistoria);

        Scene telaGame = new Scene(paneB, 1000, 800);
        return telaGame;
    }
    @Override
    public void setExecutor(Executor e) {
        this.executor = e;
    }

    @Override
    public boundary.Executor getExecutor() {
        return this.executor;
    }

    @Override
    public void handle(ActionEvent event) {
        controlGame.jogarD6 ();
    }
}