package BlueBoxStorage.BackEnd.Controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MyRestController
{
    @GetMapping
    public String sayHello()
    {
        return "hello";
    }
}
