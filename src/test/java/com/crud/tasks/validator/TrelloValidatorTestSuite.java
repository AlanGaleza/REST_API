package com.crud.tasks.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.validator.TrelloValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {
    @InjectMocks
    TrelloValidator trelloValidator;

    @Test
    public void shouldThrowTrelloTestBoard() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "test", trelloLists));
        trelloBoards.add(new TrelloBoard("2", "trello_board", trelloLists));
        //When
        List<TrelloBoard> trelloBoardsResult = trelloValidator.validateTrelloBoards(trelloBoards);
        //Then
        assertThat(1).isEqualTo(trelloBoardsResult.size());
        assertThat("2").isEqualTo(trelloBoardsResult.get(0).getId());
    }

    @Test
    public void validateCardTest() {
        //Given
        TrelloCard trelloCard1 = new TrelloCard("name", "description", "pos", "listId");
        TrelloCard trelloCard2 = new TrelloCard("test", "test_description", "test_pos", "test_listid");
        //When & Then
        trelloValidator.validateCard(trelloCard1);
        trelloValidator.validateCard(trelloCard2);
    }
}
