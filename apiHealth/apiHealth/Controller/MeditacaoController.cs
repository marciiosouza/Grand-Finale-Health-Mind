
using apiHealth.Context;
using apiHealth.Model;
using apiHealth.Repository;
using Microsoft.AspNetCore.Mvc;

namespace apiHealth.Controller
{
    [Route("/meditacoes")]
    [ApiController]
    public class MeditacaoController : ControllerBase
    {

        private readonly MeditacaoRepository meditacaoRepository;

       public MeditacaoController(AppDbContext context)
        {
            meditacaoRepository = new MeditacaoRepository(context);
        }


        [HttpGet("ObterTodos")]
        public ActionResult<List<MeditacaoModel>> GetMeditacao()
        {
            try
            {
                var lista = meditacaoRepository.ObterTodos();
                return lista;

            }catch (Exception ex)
            {
                return BadRequest(ex);
            }
        }
    }
}
