package ted.gun0912.movie.component

interface Toaster {
    fun showSuccessToast(text: CharSequence)
    fun showErrorToast(text: CharSequence)
    fun showToast(text: CharSequence, isSuccess: Boolean)
}
