// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.ui.membership;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;
import me.taste2plate.app.customer.repo.ProductRepository;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MembershipListViewModel_Factory implements Factory<MembershipListViewModel> {
  private final Provider<ProductRepository> productRepositoryProvider;

  public MembershipListViewModel_Factory(Provider<ProductRepository> productRepositoryProvider) {
    this.productRepositoryProvider = productRepositoryProvider;
  }

  @Override
  public MembershipListViewModel get() {
    return newInstance(productRepositoryProvider.get());
  }

  public static MembershipListViewModel_Factory create(
      Provider<ProductRepository> productRepositoryProvider) {
    return new MembershipListViewModel_Factory(productRepositoryProvider);
  }

  public static MembershipListViewModel newInstance(ProductRepository productRepository) {
    return new MembershipListViewModel(productRepository);
  }
}
