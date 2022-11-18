package bridge.View;

import bridge.Utils.Parser;
import bridge.Validator.Integarated.BridgeSizeValidator;
import bridge.Validator.NumericValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    BridgeSizeValidator bridgeSizeValidator;

    public InputView() {}

    public InputView(BridgeSizeValidator bridgeSizeValidator) {
        this.bridgeSizeValidator = bridgeSizeValidator;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = getInput();
        bridgeSizeValidator.validate(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }


    public String getInput() {
        return Console.readLine();
    }

}

