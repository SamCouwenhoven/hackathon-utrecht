package nl.codeforall.cannabits.teamsweat.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import nl.codeforall.cannabits.teamsweat.example.Drop;
import nl.codeforall.cannabits.teamsweat.game.LyricsFinder;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "lyricsFinder";
		config.width = 1000;
		config.height = 600;

		new LwjglApplication(new LyricsFinder(), config);
	}
}
