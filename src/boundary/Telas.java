package boundary;

import entity.Jogador;
import javafx.scene.Scene;

public interface Telas {
	Scene gerarTela();

	void setExecutor(Executor e);

	Executor getExecutor();
}
