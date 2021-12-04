package com.altaie.marvel.ui.home

import androidx.lifecycle.asLiveData
import com.altaie.marvel.domain.MarvelRepositoryImpl
import com.altaie.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: MarvelRepositoryImpl) : BaseViewModel(), HomeInteractionListener {
    val characters = repository.getAllCharacters().asLiveData()
    val comics = repository.getAllComics().asLiveData()
    val creators = repository.getAllCreators().asLiveData()
    val events = repository.getAllEvents().asLiveData()
    val series = repository.getAllSeries().asLiveData()
    val stories = repository.getAllStories().asLiveData()

    private val charactersDto = repository.getAllCharactersDto().asLiveData()
    private val comicsDto = repository.getAllComicsDto().asLiveData()
    private val creatorsDto = repository.getAllCreatorsDto().asLiveData()
    private val eventsDto = repository.getAllEventsDto().asLiveData()
    private val seriesDto = repository.getAllSeriesDto().asLiveData()
    private val storiesDto = repository.getAllStoriesDto().asLiveData()

    init {
        liveDataLauncher(charactersDto, repository::insertCharacters)
        liveDataLauncher(comicsDto, repository::insertComics)
        liveDataLauncher(creatorsDto, repository::insertCreators)
        liveDataLauncher(eventsDto, repository::insertEvents)
        liveDataLauncher(seriesDto, repository::insertSeries)
        liveDataLauncher(storiesDto, repository::insertStories)
    }

    override fun onRecyclerItemClicked() { }
}