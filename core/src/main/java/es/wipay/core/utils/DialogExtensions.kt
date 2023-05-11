package es.wipay.core.utils

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

@Suppress("LongParameterList")
fun Fragment.showConfirmationDialogYesNo(
		title: String,
		message: String,
		positiveButtonText: String,
		negativeButtonText: String,
		onPositiveButtonClicked: () -> Unit,
		onNegativeButtonClicked: (() -> Unit?)? = null
) {
	val alertDialog = AlertDialog.Builder(requireContext())
		.setTitle(title)
		.setMessage(message)
		.setPositiveButton(positiveButtonText) { dialog, _ ->
			dialog.dismiss()
			onPositiveButtonClicked.invoke()
		}
		.setNegativeButton(negativeButtonText) { dialog, _ ->
			dialog.dismiss()
			onNegativeButtonClicked?.invoke()
		}
		.create()

	alertDialog.show()
}