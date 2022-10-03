package com.ebookfrenzy.masterdetailflow

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.masterdetailflow.dummy.DummyContent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

import kotlinx.android.synthetic.main.activity_website_detail.*
import kotlinx.android.synthetic.main.website_detail.view.*

/**
 * A fragment representing a single Website detail screen.
 * This fragment is either contained in a [WebsiteListActivity]
 * in two-pane mode (on tablets) or a [WebsiteDetailActivity]
 * on handsets.
 */
class WebsiteDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var mItem: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments.containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = DummyContent.ITEM_MAP[arguments.getString(ARG_ITEM_ID)]
            mItem?.let {
                activity.toolbar_layout?.title = it.website_name
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.website_detail, container, false)

        // Show the dummy content as text in a TextView.
        mItem?.let {
            val webView: WebView = rootView.findViewById(R.id.website_detail)
            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                        view: WebView, request: WebResourceRequest): Boolean {
                    return super.shouldOverrideUrlLoading(
                            view, request)
                }
            }
            webView.settings.javaScriptEnabled = true
            webView.loadUrl(mItem?.website_url)
        }

        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
