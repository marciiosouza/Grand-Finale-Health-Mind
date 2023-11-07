using apiHealthMind.Context;
using apiHealthMind.Model;
using apiHealthMind.Repository;

using Microsoft.AspNetCore.Mvc;


namespace apiHealthMind.Controllers
{
    
    
    public class UsuarioController : ControllerBase
    {
        private readonly UsuarioRepository usuarioRepository;

        public UsuarioController(AppDbContext dbx )    {
            usuarioRepository = new UsuarioRepository(dbx);
        }

        [HttpPost("cadastrar")]
        public ActionResult<UsuarioModel> Post([FromBody] UsuarioModel usuario)
        {
            try
            {
                usuarioRepository.InserirUsuario(usuario);
                return usuario;
            }
            catch (Exception ex)
            {
                return BadRequest(new { message = $"Não foi possível cadastrar suspeito" });
            }
        }


        
    }
}
