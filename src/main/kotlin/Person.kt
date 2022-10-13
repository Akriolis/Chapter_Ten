import ru.yole.jkid.JsonExclude
import ru.yole.jkid.JsonName

data class Person (
    @JsonName ("alias") val firstName: String,
    @JsonExclude val age: Int? = null
    ){
}