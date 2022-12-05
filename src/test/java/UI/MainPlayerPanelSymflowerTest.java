package UI;

import UseCase.EndTurn.EndTurnController;
import UseCase.EndTurn.EndTurnResponseModel;
import UseCase.GameBoard.GameboardController;
import UseCase.ThrowCard.ThrowCardController;
import UseCase.UseCard.UseCardController;
import entity.Player;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainPlayerPanelSymflowerTest {
	@Test
	public void MainPlayerPanel1() {
		MainPlayerPanel expected = null; // TODO This is a fallback value due to incomplete analysis.
		MainPlayerPanel actual = new MainPlayerPanel();

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	@Test
	public void displayHP2() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		String hp = null; // TODO This is a fallback value due to incomplete analysis.
		m.displayHP(hp);
	}

	@Test
	public void displayIns3() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		String instruction = null; // TODO This is a fallback value due to incomplete analysis.
		m.displayIns(instruction);
	}

	@Test
	public void displayName4() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		String name = null; // TODO This is a fallback value due to incomplete analysis.
		m.displayName(name);
	}

	@Test
	public void displayPlayerNum5() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		String pn = null; // TODO This is a fallback value due to incomplete analysis.
		m.displayPlayerNum(pn);
	}

	@Test
	public void displayRD6() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		int rd = 0; // TODO This is a fallback value due to incomplete analysis.
		m.displayRD(rd);
	}

	@Test
	public void displayRole7() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		String captain = null; // TODO This is a fallback value due to incomplete analysis.
		HashMap roleExist = null; // TODO This is a fallback value due to incomplete analysis.
		m.displayRole(captain, roleExist);
	}

	@Test
	public void setEndTurnController8() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		EndTurnController endTurnController = null; // TODO This is a fallback value due to incomplete analysis.
		m.setEndTurnController(endTurnController);
	}

	@Test
	public void setGameboardController9() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		GameboardController gameboardController = null; // TODO This is a fallback value due to incomplete analysis.
		m.setGameboardController(gameboardController);
	}

	@Test
	public void setPcards10() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		List<String> pcards = null; // TODO This is a fallback value due to incomplete analysis.
		m.setPcards(pcards);
	}

	@Test
	public void setPlayer11() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		Player player = null; // TODO This is a fallback value due to incomplete analysis.
		m.setPlayer(player);
	}

	@Test
	public void setPlist12() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		List<String> plist = null; // TODO This is a fallback value due to incomplete analysis.
		m.setPlist(plist);
	}

	@Test
	public void setThrowCardController13() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		ThrowCardController throwCardController = null; // TODO This is a fallback value due to incomplete analysis.
		m.setThrowCardController(throwCardController);
	}

	@Test
	public void setUseCardController14() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		UseCardController useCardController = null; // TODO This is a fallback value due to incomplete analysis.
		m.setUseCardController(useCardController);
	}

	@Test
	public void throwView15() {
		MainPlayerPanel m = null; // TODO This is a fallback value due to incomplete analysis.
		EndTurnResponseModel endTurnResponseModel = null; // TODO This is a fallback value due to incomplete analysis.
		m.throwView(endTurnResponseModel);
	}
}
