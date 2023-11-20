
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
                return Ok(lista);

            }catch (Exception ex)
            {
                return BadRequest(ex);
            }
        }

        [HttpGet("PesquisarMeditacao")]
        public ActionResult<List<MeditacaoModel>> PesquisarMeditacao([FromQuery] string tituloMeditacao)
        {
            try
            {
                var lista = meditacaoRepository.PesquisarMeditacao(tituloMeditacao);
                return Ok(lista);
            }
            catch (Exception ex)
            {
                return BadRequest("Meditação não encontrada");
            }
        }

        [HttpPost("CadastrarMeditacao")]
        public ActionResult<MeditacaoModel> PostMeditacao([FromBody] MeditacaoModel meditacao)
        {
            try
            {
                meditacaoRepository.CadastrarMeditacao(meditacao);
                return Ok(meditacao);
            }catch(Exception ex)
            {
                return BadRequest("Erro ao cadastrar");
            }
        }

        [HttpGet("{id:int}")]
        public ActionResult<MeditacaoModel> PesquisarPorId([FromRoute] int id)
        {
            try
            {
                var meditacao = meditacaoRepository.PesquisarPorId(id);

                if (meditacao == null)
                {
                    return NotFound();
                }

                return Ok(meditacao);
            }
            catch (Exception ex)
            {
                
                return StatusCode(500, $"Erro interno: {ex.Message}");
            }
        }

    }
}
