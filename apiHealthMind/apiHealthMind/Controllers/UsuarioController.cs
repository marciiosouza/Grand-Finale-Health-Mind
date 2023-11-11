using apiHealthMind.Context;
using apiHealthMind.Model;
using apiHealthMind.Repository;
using Microsoft.AspNetCore.Mvc;

namespace apiHealthMind.Controllers
{
    [Route("/usuario")]
    [ApiController]
    public class UsuarioController : ControllerBase
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
                return BadRequest("Não é possível cadastrar usuario");

            }


        }

        [HttpPost("/login")]
        public ActionResult<UsuarioModel> ObterUsuarioCadastrado( [FromBody] UsuarioModel usuarioModel) 
        {
            try
            {
                var usuarioCadastrado = usuarioRepository.buscaUsuario(usuarioModel.email , usuarioModel.senha);

                return Ok(usuarioCadastrado);
            }catch(Exception ex)
            {
                return BadRequest("Usuario não encontrado");
            }
        }
    }
}
