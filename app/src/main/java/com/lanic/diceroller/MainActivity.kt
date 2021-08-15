package com.lanic.diceroller

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Column {
                    messageCard(
                        Message(
                            author = "Android",
                            name = "이제 메시지를 클릭하면 isExpanded에 따라 메시지 콘텐츠의 배경을 변경할 수 있습니다. clickable 수정자를 사용하여 컴포저블의 클릭 이벤트를 처리합니다. 단순히 Surface의 배경색을 전환하는 대신 MaterialTheme.colors.surface에서 MaterialTheme.colors.primary로 또는 그 반대로 값을 점진적으로 수정하여 배경색에 애니메이션을 적용할 수 있습니다. 이를 위해 animateColorAsState 함수를 사용합니다. 마지막으로 animateContentSize 수정자를 사용하여 메시지 컨테이너 크기에 부드럽게 애니메이션을 적용합니다."
                        )
                    )
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(
                        Message(
                            author = "Android",
                            name = "이제 메시지를 클릭하면 isExpanded에 따라 메시지 콘텐츠의 배경을 변경할 수 있습니다. clickable 수정자를 사용하여 컴포저블의 클릭 이벤트를 처리합니다. 단순히 Surface의 배경색을 전환하는 대신 MaterialTheme.colors.surface에서 MaterialTheme.colors.primary로 또는 그 반대로 값을 점진적으로 수정하여 배경색에 애니메이션을 적용할 수 있습니다. 이를 위해 animateColorAsState 함수를 사용합니다. 마지막으로 animateContentSize 수정자를 사용하여 메시지 컨테이너 크기에 부드럽게 애니메이션을 적용합니다."
                        )
                    )
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))
                    messageCard(Message(author = "Android", name = "Jetpack Compose"))

                }
            }
        }
    }

    data class Message(val author: String, val name: String)

    @Composable
    fun messageCard(message: Message) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "AppIcon",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor: Color by animateColorAsState(targetValue = if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface)

            Column(modifier = Modifier.clickable { isExpanded = isExpanded.not() }) {
                Text(
                    text = message.author,
                    color = MaterialTheme.colors.secondaryVariant,
                    style = MaterialTheme.typography.subtitle2
                )
                Spacer(modifier = Modifier.height(4.dp))
                Surface(
                    color = surfaceColor,
                    shape = MaterialTheme.shapes.medium,
                    elevation = 1.dp,
                    modifier = Modifier
                        .animateContentSize()
                        .padding(1.dp)
                ) {
                    Text(
                        text = message.name,
                        modifier = Modifier.padding(4.dp),
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

    @Composable
    fun Conversation(messages: List<Message>) {
        LazyColumn {
            items(messages) { msg ->
                messageCard(message = msg)
            }
        }
    }


    @Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
    @Preview(
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        showBackground = true,
        name = "Dark Mode"
    )
    @Composable
    fun PreviewMessageCard() {
        MaterialTheme {
            messageCard(message = Message("Android", "Test Compose"))
        }
    }

    @Preview
    @Composable
    fun PreviewConversation() {
        Conversation(messages = listOf(Message("lanic", "compose 재밌네"), Message("누군가", "ㅇㅇ")))
    }
}