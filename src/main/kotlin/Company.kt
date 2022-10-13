import ru.yole.jkid.DeserializeInterface

interface Company {
    val name: String
}

data class CompanyImpl(override val name: String): Company

data class Person2(
    val name: String,
    @DeserializeInterface(CompanyImpl::class) val company: Company
)