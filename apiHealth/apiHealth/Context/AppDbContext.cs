using apiHealth.Model;
using Microsoft.EntityFrameworkCore;

namespace apiHealth.Context
{
    public class AppDbContext : DbContext
    {
        public DbSet<UsuarioModel> usuario { get; set; }
        public DbSet<MeditacaoModel> meditacao { get; set; }
        public DbSet<MeditacaoDestaque> meditacaoDestaque { get; set; }

        public AppDbContext(DbContextOptions options) : base(options) { }

        protected AppDbContext() { }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<MeditacaoDestaque>()
                .HasKey(md => new { md.MeditacaoId, md.DataAcesso });

            // Outras configurações do modelo, se houver...

            base.OnModelCreating(modelBuilder);
        }

    }
}
