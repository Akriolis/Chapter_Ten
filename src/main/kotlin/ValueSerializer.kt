import ru.yole.jkid.CustomSerializer
import java.util.Date
import kotlin.reflect.KClass

interface ValueSerializer <T> {
    fun toJsonValue(value: T): Any?
    fun fromJsonValue(jsinValue: Any?): T
}

data class Person3(
    val name: String,
    //@CustomSerializer(DateSerializer::class) val birthDate: Date
)

annotation class CustomSerializer(
    val serializerClass: KClass<out ValueSerializer<*>>
)