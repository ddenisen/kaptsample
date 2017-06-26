package net.denisen.kaptsample

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import java.util.*

class MainActivity : AppCompatActivity() {

    @BindView(R.id.main_label)
    lateinit var mainLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val locales = listOf(
                Locale.getDefault()
        )

        mainLabel.text = "Hello! Locale is ${locales.toLocaleLabels()[0].getLabel(this)}"
    }
}

interface Item {
    fun getLabel(context: Context): CharSequence
}

private fun Collection<Locale>.toLocaleLabels() =
        map { locale ->
            object: Item {
                override fun getLabel(context: Context) = locale.getDisplayName()
            }
        }