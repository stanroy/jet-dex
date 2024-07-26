package com.stanroy.jetdex.presentation.pokemon_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stanroy.jetdex.R
import com.stanroy.jetdex.presentation.common.rememberKeyboardManager
import com.stanroy.jetdex.presentation.common.zero
import kotlinx.serialization.Serializable
import timber.log.Timber

@Serializable
object PokemonListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListScreenView(
    modifier: Modifier = Modifier, viewModel: PokemonListViewModel = hiltViewModel()
) {
    val pokemonList by viewModel.pokemonList.collectAsState()
    val keyboardManager = rememberKeyboardManager()
    var query by remember { mutableStateOf("") }
    var isSearchBarFocused by remember { mutableStateOf(false) }

    SearchBar(
        modifier = Modifier.onFocusChanged {
            isSearchBarFocused = it.isFocused
        },
        query = query,
        onQueryChange = { query = it },
        onSearch = {
            Timber.tag("TAG_TAG").d("xd")
            keyboardManager.hideKeyboard()
        },
        active = true,
        windowInsets = WindowInsets.zero,
        leadingIcon = {
            AnimatedVisibility(
                visible = isSearchBarFocused,
                enter = expandIn(expandFrom = Alignment.BottomCenter) + fadeIn(),
                exit = fadeOut()
            ) {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable {
                            keyboardManager.hideKeyboard()
                        },
                    painter = painterResource(id = R.drawable.arrow_down),
                    contentDescription = "clear search input"
                )
            }
        },
        trailingIcon = {
            AnimatedVisibility(
                visible = query.isNotEmpty(),
                enter = expandIn(expandFrom = Alignment.CenterStart) + fadeIn(),
                exit = fadeOut()
            ) {
                Icon(
                    modifier = Modifier
                        .clip(CircleShape)
                        .clickable { query = "" },
                    painter = painterResource(id = R.drawable.cross),
                    contentDescription = "clear search input"
                )
            }
        },
        onActiveChange = {}
    ) {
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 32.dp)) {
            items(items = pokemonList) {
                PokemonListItem(it)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }


}


@Composable
private fun PokemonListItem(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
            .padding(64.dp)
    ) {
        Text(text = name)
    }
}

@Composable
private fun PokemonListContent() {

}