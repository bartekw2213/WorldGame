package com.pg.student.swingLogic.stages.getInitDataStage.controller;

import com.pg.student.Program;
import com.pg.student.swingLogic.Controller;
import com.pg.student.swingLogic.View;

public class GetInitDataController extends Controller {
    private int boardSize = 0;
    private int organismsNum = 0;
    private String errorMessage = "";
    private static final int minBoardSizeAndOrganismsNum = 10;

    public GetInitDataController(Program mainProgram, View view) {
        super(mainProgram, view);
    }

    public void InformAboutInitialGameData(String boardSizeInput, String organismsNumInput) {
        if(IsDataCorrect(boardSizeInput, organismsNumInput)) {
            boardSize = Integer.parseInt(boardSizeInput);
            organismsNum = Integer.parseInt(organismsNumInput);
            super.CloseView();
            super.EndStage();
        } else
            view.ShowErrorDialog(errorMessage);
    }

    private boolean IsDataCorrect(String boardSizeInput, String organismsNumInput) {
        if(boardSizeInput.isEmpty() || organismsNumInput.isEmpty()) {
            errorMessage = "Wprowadź pełne dane";
            return false;
        }

        if(IsNotInteger(boardSizeInput) || IsNotInteger(organismsNumInput)) {
            errorMessage = "Wprowadzone dane nie są liczbą całkowitą";
            return false;
        }

        if(IsNotCorrectNumber(boardSizeInput) || IsNotCorrectNumber(organismsNumInput)) {
            errorMessage = "Minimalna wielkość i ilość organizmów to 10";
            return false;
        }

        if(IsBoardNotBiggerThanOrganismsNum(boardSizeInput, organismsNumInput)) {
            errorMessage = "Za mała plansza dla tej liczby organizmów";
            return false;
        }
        
        return true;
    }

    private boolean IsNotInteger(String checkedString) {
        try {
            Integer.parseInt(checkedString);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
    
    private boolean IsNotCorrectNumber(String checkedNumber) {
        int number = Integer.parseInt(checkedNumber);
        return number < minBoardSizeAndOrganismsNum;
    }

    private boolean IsBoardNotBiggerThanOrganismsNum(String boardSizeInput, String organimsNumInput) {
        int boardSize = Integer.parseInt(boardSizeInput);
        int organismsNum = Integer.parseInt(organimsNumInput);

        return ((boardSize * boardSize) < organismsNum);
    }

    public int GetBoardSize() {
        return boardSize;
    }

    public int GetOrganismsNum() {
        return organismsNum;
    }
}
