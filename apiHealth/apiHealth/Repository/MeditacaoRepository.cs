using apiHealth.Context;
using apiHealth.Model;

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
    }
}
