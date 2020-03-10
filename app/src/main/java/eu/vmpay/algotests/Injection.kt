package eu.vmpay.algotests

object Injection {

    private val database by lazy { Database() }

    fun provideDatabase() = database
}
