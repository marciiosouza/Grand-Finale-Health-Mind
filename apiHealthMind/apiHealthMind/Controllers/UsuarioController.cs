using apiHealthMind.Context;
using apiHealthMind.Model;
using apiHealthMind.Repository;
using Microsoft.AspNetCore.Mvc;

namespace apiHealthMind.Controllers
{
    [Route("/usuario")]
    [ApiController]
    public class UsuarioController
    {
        private readonly UsuarioRepository usuarioRepository;

        public UsuarioController(AppDbContext dbx )    {
            usuarioRepository = new UsuarioRepository(dbx);
        }

        [HttpPost("/cadastrar")]
        public ActionResult<UsuarioModel> Post([FromBody] UsuarioModel usuario)
        {
            try
            {
                usuarioRepository.InserirUsuario(usuario);
                
                   return  usuario;
            }
            catch (Exception ex)
            {
                return new JsonResult(ex.ToString());

            }


        }
    }
}
