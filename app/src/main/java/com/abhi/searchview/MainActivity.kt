package com.abhi.searchview

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.abhi.searchview.search.SearchItem
import com.abhi.searchview.search.SearchView
import com.abhi.searchview.search.bindSearchView
import com.abhi.searchview.utils.toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        if (searchView == null) searchView = bindSearchView(menu, R.id.action_search) {



            textCallback = { query, searchView ->
                val items = wordBank.filter { it.contains(query) }.sorted().map { SearchItem(it) }
                searchView.results = items
            }
            searchCallback = { query, _ ->
                toast("Enter pressed for $query")
                true
            }
            textDebounceInterval = 0
            noResultsFound = R.string.no_results_found
            shouldClearOnClose = false
            onItemClick = { _, _, content, searchView ->
                toast(content)
                searchView.revealClose()
            }

        }


        return true
    }

    companion object {

        //some of the most common english words for show
        val wordBank: List<String> by lazy {
            listOf("the", "name", "of", "very", "to", "through",
                    "and", "just", "a", "form", "in", "much", "is", "great", "it", "think", "you", "say",
                    "that", "help", "he", "low", "was", "line", "for", "before", "on", "turn", "are", "cause",
                    "with", "same", "as", "mean", "I", "differ", "his", "move", "they", "right", "be", "boy",
                    "at", "old", "one", "too", "have", "does", "this", "tell", "from", "sentence", "or", "set",
                    "had", "three", "by", "want", "hot", "air", "but", "well", "some", "also", "what", "play",
                    "there", "small", "we", "end", "can", "put", "out", "home", "other", "read", "were", "hand",
                    "all", "port", "your", "large", "when", "spell", "up", "add", "use", "even", "word", "land",
                    "how", "here", "said", "must", "an", "big", "each", "high", "she", "such", "which", "follow",
                    "do", "act", "their", "why", "time", "ask", "if", "men", "will", "change", "way", "went",
                    "about", "light", "many", "kind", "then", "off", "them", "need", "would", "house", "write",
                    "picture", "like", "try", "so", "us", "these", "again", "her", "animal", "long", "point",
                    "make", "mother", "thing", "world", "see", "near", "him", "build", "two", "self", "has",
                    "earth", "look", "father", "more", "head", "day", "stand", "could", "own", "go", "page",
                    "come", "should", "did", "country", "my", "found", "sound", "answer", "no", "school", "most",
                    "grow", "number", "study", "who", "still", "over", "learn", "know", "plant", "water", "cover",
                    "than", "food", "call", "sun", "first", "four", "people", "thought", "may", "let", "down", "keep",
                    "side", "eye", "been", "never", "now", "last", "find", "door", "any", "between", "new", "city",
                    "work", "tree", "part", "cross", "take", "since", "get", "hard", "place", "start", "made",
                    "might", "live", "story", "where", "saw", "after", "far", "back", "sea", "little", "draw",
                    "only", "left", "round", "late", "man", "run", "year", "don't", "came", "while", "show",
                    "press", "every", "close", "good", "night", "me", "real", "give", "life", "our", "few", "under",
                    "stopRankWordRankWord", "open", "ten", "seem", "simple", "together", "several", "next",
                    "vowel", "white", "toward", "children", "war", "begin", "lay", "got", "against", "walk", "pattern",
                    "example", "slow", "ease", "center", "paper", "love", "often", "person", "always", "money",
                    "music", "serve", "those", "appear", "both", "road", "mark", "map", "book", "science", "letter",
                    "rule", "until", "govern", "mile", "pull", "river", "cold", "car", "notice", "feet", "voice",
                    "care", "fall", "second", "power", "group", "town", "carry", "fine", "took", "certain", "rain",
                    "fly", "eat", "unit", "room", "lead", "friend", "cry", "began", "dark", "idea", "machine",
                    "fish", "note", "mountain", "wait", "north", "plan", "once", "figure", "base", "star", "hear",
                    "box", "horse", "noun", "cut", "field", "sure", "rest", "watch", "correct", "color", "able",
                    "face", "pound", "wood", "done", "main", "beauty", "enough", "drive", "plain", "stood", "girl",
                    "contain", "usual", "front", "young", "teach", "ready", "week", "above", "final", "ever", "gave",
                    "red", "green", "list", "oh", "though", "quick", "feel", "develop", "talk", "sleep", "bird",
                    "warm", "soon", "free", "body", "minute", "dog", "strong", "family", "special", "direct", "mind",
                    "pose", "behind", "leave", "clear", "song", "tail", "measure", "produce", "state", "fact", "product",
                    "street", "black", "inch", "short", "lot", "numeral", "nothing", "class", "course", "wind", "stay",
                    "question", "wheel", "happen", "full", "complete", "force", "ship", "blue", "area", "object", "half",
                    "decide", "rock", "surface", "order", "deep", "fire", "moon", "south", "island", "problem", "foot",
                    "piece", "yet", "told", "busy", "knew", "test", "pass", "record", "farm", "boat", "top", "common",
                    "whole", "gold", "king", "possible", "size", "plane", "heard", "age", "best", "dry", "hour", "wonder",
                    "better", "laugh", "true.", "thousand", "during", "ago", "hundred", "ran", "am", "check", "remember",
                    "game", "step", "shape", "early", "yes", "hold", "hot", "west", "miss", "ground", "brought", "interest",
                    "heat", "reach", "snow", "fast", "bed", "five", "bring", "sing", "sit", "listen", "perhaps", "six",
                    "fill", "table", "east", "travel", "weight", "less", "language", "morning", "among")
        }
    }


}
