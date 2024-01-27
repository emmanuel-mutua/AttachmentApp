import androidx.compose.ui.graphics.Color
import com.emmutua.attachmentapp.ui.theme.AngryColor
import com.emmutua.attachmentapp.ui.theme.AwfulColor
import com.emmutua.attachmentapp.ui.theme.BoredColor
import com.emmutua.attachmentapp.ui.theme.CalmColor
import com.emmutua.attachmentapp.ui.theme.DepressedColor
import com.emmutua.attachmentapp.ui.theme.DisappointedColor
import com.emmutua.attachmentapp.ui.theme.HappyColor
import com.emmutua.attachmentapp.ui.theme.HumorousColor
import com.emmutua.attachmentapp.ui.theme.LonelyColor
import com.emmutua.attachmentapp.ui.theme.MysteriousColor
import com.emmutua.attachmentapp.ui.theme.NeutralColor
import com.emmutua.attachmentapp.ui.theme.RomanticColor
import com.emmutua.attachmentapp.ui.theme.ShamefulColor
import com.emmutua.attachmentapp.ui.theme.SurprisedColor
import com.emmutua.attachmentapp.ui.theme.SuspiciousColor
import com.emmutua.attachmentapp.ui.theme.TenseColor

enum class LogColors(
    val contentColor: Color,
    val containerColor: Color,
) {
    ColorStyle1(
        contentColor = Color.Black,
        containerColor = NeutralColor,
    ),
    ColorStyle2(
        contentColor = Color.Black,
        containerColor = HappyColor,
    ),
    ColorStyle3(
        contentColor = Color.White,
        containerColor = AngryColor,
    ),
    ColorStyle4(
        contentColor = Color.Black,
        containerColor = BoredColor,
    ),
    ColorStyle5(
        contentColor = Color.Black,
        containerColor = CalmColor,
    ),
    ColorStyle6(
        contentColor = Color.Black,
        containerColor = DepressedColor,
    ),
    ColorStyle7(
        contentColor = Color.White,
        containerColor = DisappointedColor,
    ),
    ColorStyle8(
        contentColor = Color.Black,
        containerColor = HumorousColor,
    ),
    ColorStyle9(
        contentColor = Color.White,
        containerColor = LonelyColor,
    ),
    ColorStyle10(
        contentColor = Color.Black,
        containerColor = MysteriousColor,
    ),
    ColorStyle11(
        contentColor = Color.White,
        containerColor = RomanticColor,
    ),
    ColorStyle12(
        contentColor = Color.White,
        containerColor = ShamefulColor,
    ),
    ColorStyle13(
        contentColor = Color.Black,
        containerColor = AwfulColor,
    ),
    ColorStyle14(
        contentColor = Color.Black,
        containerColor = SurprisedColor,
    ),
    ColorStyle15(
        contentColor = Color.Black,
        containerColor = SuspiciousColor,
    ),
    ColorStyle16(
        contentColor = Color.Black,
        containerColor = TenseColor,
    ),
}
