package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;

    public GameController(BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
    }

    public void GAMESTART() {
        try {
            MAKEBRIDGE();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            GAMESTART();
        }
    }

    public void MAKEBRIDGE() {
        int input = inputView.readBridgeSize();
        bridgeGame.setBridge(bridgeMaker.makeBridge(input));
    }

    public void printGameStart() {
        outputView.printGameStart();
    }

    public void RUNPROCESS() {
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            boolean match = bridgeGame.move(inputView,outputView,i);
            if (!match) { break; }
        }
        bridgeGame.increaseGameCount();
    }

    public boolean SELECTRESTART() {
        return bridgeGame.retry(inputView);
    }

    public void STOPGAME() {
        outputView.printResult(bridgeGame);
    }


}
