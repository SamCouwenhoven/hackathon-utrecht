package nl.codeforall.cannabits.teamsweat.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import nl.codeforall.cannabits.teamsweat.example.Drop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "lyricsFinder";
		config.width = 800;
		config.height = 480;

		new LwjglApplication(new Drop(), config);
	}
}
