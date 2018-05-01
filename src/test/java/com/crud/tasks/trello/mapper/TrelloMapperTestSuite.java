package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {
    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void cardAndCardDtoMappingTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("trello_card", "trello_card_description", "1", "C1");
        TrelloCardDto trelloCardDto = new TrelloCardDto("trello_card_dto", "trello_card_dto_description", "1", "CDto1");
        //When
        TrelloCardDto trelloCardDtoResult = trelloMapper.mapToCardDto(trelloCard);
        TrelloCard trelloCardResult = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertThat("trello_card").isEqualTo(trelloCardDtoResult.getName());
        assertThat("trello_card_dto").isEqualTo(trelloCardResult.getName());
    }

    @Test
    public void listAndListDtoMappingTest() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "trello_list", false));

        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "trello_list_dto", false));
        //When
        List<TrelloListDto> trelloListsDtoResult = trelloMapper.mapToListDto(trelloLists);
        List<TrelloList> trelloListsResult = trelloMapper.mapToList(trelloListDtos);
        //Then
        assertThat(1).isEqualTo(trelloListsDtoResult.size());
        assertThat(1).isEqualTo(trelloListsResult.size());
        assertThat("trello_list").isEqualTo(trelloListsDtoResult.get(0).getName());
        assertThat("trello_list_dto").isEqualTo(trelloListsResult.get(0).getName());
    }

    @Test
    public void boardAndBoardDtoMappingTest() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "trello_list", false));

        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "trello_list_dto", false));

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "trello_board", trelloLists));

        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("1", "trello_board_dto", trelloListDtos));
        //When
        List<TrelloBoardDto> trelloBoardsDtoResult = trelloMapper.mapToBoardsDto(trelloBoards);
        List<TrelloBoard> trelloBoardsResult = trelloMapper.mapToBoards(trelloBoardsDto);
        //Then
        assertThat(1).isEqualTo(trelloBoardsDto.size());
        assertThat(1).isEqualTo(trelloBoards.size());
        assertThat("trello_board").isEqualTo(trelloBoardsDtoResult.get(0).getName());
        assertThat("trello_board_dto").isEqualTo(trelloBoardsResult.get(0).getName());
    }
}
