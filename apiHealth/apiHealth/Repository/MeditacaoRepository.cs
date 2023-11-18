using apiHealth.Context;
using apiHealth.Model;
using Microsoft.EntityFrameworkCore;

namespace apiHealth.Repository
{
    public class MeditacaoRepository
    {
        private readonly AppDbContext dataBaseContext;

        public MeditacaoRepository(AppDbContext dataBaseContext)
        {
            this.dataBaseContext = dataBaseContext;
        }

        public List<MeditacaoModel> ObterTodos()
        {
            var lista = new List<MeditacaoModel>();
             lista = dataBaseContext.meditacao.ToList< MeditacaoModel>();

            return lista;
        }

        public List<MeditacaoModel> PesquisarMeditacao(string tituloMeditacao)
        {
            var lista = dataBaseContext.meditacao.Where(m => m.Titulo.Contains(tituloMeditacao)).ToList();

            return lista;
        }

        public void CadastrarMeditacao(MeditacaoModel meditacao)
        {
            dataBaseContext.meditacao.Add(meditacao);
            dataBaseContext.SaveChanges();
        }
    }
}
