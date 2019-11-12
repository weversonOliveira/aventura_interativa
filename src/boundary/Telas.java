package boundary;

import javafx.scene.Scene;

public interface Telas {
	Scene gerarTela();

	void setExecutor(Executor e);

	Executor getExecutor();
}
