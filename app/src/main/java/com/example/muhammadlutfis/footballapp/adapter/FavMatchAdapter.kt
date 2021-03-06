package com.example.muhammadlutfis.footballapp.adapter

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.muhammadlutfis.footballapp.R
import com.example.muhammadlutfis.footballapp.R.id.*
import com.example.muhammadlutfis.footballapp.db.FavoriteMatch
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class FavMatchAdapter (private val favoriteMatches: List<FavoriteMatch>
                       , private val listener: (FavoriteMatch) -> Unit)
    : RecyclerView.Adapter<FavoriteMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMatchViewHolder {
        return FavoriteMatchViewHolder(FavoriteMatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = favoriteMatches.size

    override fun onBindViewHolder(holder: FavoriteMatchViewHolder, position: Int) {
        holder.bindItem(favoriteMatches[position], listener)
    }
}

class FavoriteMatchViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val matchDate: TextView = view.find(date_match)
    private val homeName: TextView = view.find(name_home)
    private val awayName: TextView = view.find(name_away)
    private val score: TextView = view.find(score_match)
    val cv: CardView = view.find(cv_item)

    fun bindItem(favoriteMatchMatch: FavoriteMatch, listener: (FavoriteMatch) -> Unit) {
        homeName.text = favoriteMatchMatch.strHomeTeam
        awayName.text = favoriteMatchMatch.strAwayTeam
        if (favoriteMatchMatch.intHomeScore != null) {
            score.text = favoriteMatchMatch.intHomeScore + " VS " + favoriteMatchMatch.intAwayScore
        } else {
            score.text = " VS "
        }
        matchDate.text = favoriteMatchMatch.dateEvent
        cv.setOnClickListener { _: View ->
            listener(favoriteMatchMatch)
        }
    }
}

class FavoriteMatchUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            cardView {
                id = R.id.cv_item
                lparams(width = matchParent, height = wrapContent) {
                    topMargin = dip(16)
                    rightMargin = dip(16)
                    leftMargin = dip(16)
                }

                linearLayout {
                    orientation = LinearLayout.VERTICAL
                    padding = dip(16)

                    textView {
                        id = R.id.date_match
                        gravity = Gravity.CENTER
                    }.lparams {
                        width = matchParent
                    }

                    linearLayout {
                        lparams(width = matchParent, height = wrapContent)
                        orientation = LinearLayout.HORIZONTAL

                        textView {
                            id = R.id.name_home
                            gravity = Gravity.CENTER
                        }.lparams {
                            width = matchParent
                            weight = 1f
                        }

                        textView {
                            id = R.id.score_match
                            gravity = Gravity.CENTER
                        }.lparams {
                            width = matchParent
                            weight = 1f
                        }

                        textView {
                            id = R.id.name_away
                            gravity = Gravity.CENTER
                        }.lparams {
                            width = matchParent
                            weight = 1f
                        }
                    }
                }
            }
        }
    }
}