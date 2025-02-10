package ted.gun0912.movie.domain.usecase

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ted.gun0912.movie.data_resource.DataResource
import ted.gun0912.movie.domain.model.SummaryActor
import ted.gun0912.movie.domain.repository.MovieRepository
import ted.gun0912.movie.domain.utils.MainCoroutineRule

@ExperimentalCoroutinesApi
class GetActorListUseCaseTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var getActorListUseCase: GetActorListUseCase

    @MockK
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        getActorListUseCase = GetActorListUseCase(movieRepository)
    }

    @Test
    fun `getActors가 성공적으로 데이터를 반환하면 Success 상태를 방출`() = runTest {
        // Given
        val movieId = 0

        val mockCompanies = listOf(
            SummaryActor(1, "Actor Name", "Mafia", 1.0f, null, "url")
        )

        coEvery { movieRepository.getActors(movieId) } returns flowOf(
            DataResource.success(
                mockCompanies
            )
        )

        // When
        val result = getActorListUseCase(movieId).first()

        // Then
        assert(result is DataResource.Success)
        assertEquals(mockCompanies, (result as DataResource.Success).data)
    }

    @Test
    fun `getActors가 실패하면 Error 상태를 방출`() = runTest {
        // Given
        val movieId = 0
        val exception = Exception("Human Error")

        coEvery { movieRepository.getActors(movieId) } returns flowOf(DataResource.error(exception))

        // When
        val result = getActorListUseCase(movieId).first()

        // Then
        assert(result is DataResource.Error)
        assertEquals(exception, (result as DataResource.Error).throwable)
    }

    @Test
    fun `getActors가 데이터를 로딩 중이면 Loading 상태를 방출`() = runTest {
        // Given
        val movieId = 0

        coEvery { movieRepository.getActors(movieId) } returns flowOf(DataResource.loading())

        // When
        val result = getActorListUseCase(movieId).first()

        // Then
        assert(result is DataResource.Loading)
    }
}