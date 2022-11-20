package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;

    public GameController(InputView inputView, BridgeGame bridgeGame, BridgeMaker bridgeMaker, OutputView outputView) {
        this.inputView = inputView;
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
        this.outputView = outputView;
    }


    public void GAMESTART() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int input = inputView.readBridgeSize();
        bridgeGame.setBridgeSize(input);
        bridgeGame.setBridge(bridgeMaker.makeBridge(input));
    }

    public void RUNPROCESS() {
        bridgeGame.increaseGameCount();
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            boolean match = bridgeGame.move(inputView,outputView,i);
            if (!match) { break; }
            if (i == bridgeGame.getBridgeSize() - 1) { bridgeGame.gameSuccecs(); }
        }
    }

    public boolean SELECTRESTART() {
        return bridgeGame.retry(inputView,bridgeGame);
    }

    public void STOPGAME() {
        outputView.printResult(bridgeGame);
    }


}
