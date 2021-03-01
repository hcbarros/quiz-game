import { render, screen } from '@testing-library/react';
import { Welcome } from './screens/welcome/welcome';

test('renders learn react link', () => {
  render(<Welcome />);
  const linkElement = screen.getByText(/Bem vindo ao Quiz Game/i);
  expect(linkElement).toBeInTheDocument();
});
