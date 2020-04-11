package com.ghalym.postsexample

import com.ghalym.postsexample.ui.Posts.data.Post
import com.ghalym.postsexample.ui.Posts.data.PostRepository
import com.ghalym.postsexample.ui.Posts.presenter.IPostPresenter
import com.ghalym.postsexample.ui.Posts.presenter.Presenter
import com.ghalym.postsexample.ui.Posts.view.IPostView
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PostRepositoryUnitTest {

    @Rule
    @JvmField
    val mockRule = MockitoJUnit.rule()
    @Mock
    lateinit var iPostView: IPostView


    lateinit var presenter: Presenter

    @Mock
    lateinit var postRepository: PostRepository


    @Before
    fun setup() {
        presenter = Presenter(iPostView, postRepository);
    }

    @Test
    fun `check that presenter show progress before load data from repository  for one time`() {
        presenter.getPostsFromRepo();
        verify(iPostView, times(1)).showLoading()
    }

    @Test
    fun `check that presenter request load data from repository for one time`() {
        presenter.getPostsFromRepo();
        verify(postRepository, times(1)).getAllPosts(presenter)
    }


    @Throws(Exception::class)
    @Test
    fun `check that presenter hide progress`() {
        presenter.onSuccess(ArrayList())
        verify(iPostView, times(1)).hideLoading()
    }


    @Test
    @Throws(Exception::class)
    fun `check that presenter show Error`() {
     presenter.onFail("error")
        verify(iPostView, times(1)).showError("error") // 3
    }

}
